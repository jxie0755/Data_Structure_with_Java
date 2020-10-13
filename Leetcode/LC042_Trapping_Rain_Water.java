/**
 * https://leetcode.com/problems/trapping-rain-water/
 * P042 Trapping Rain Water
 * Hard
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
class LC042_Trapping_Rain_Water {

    int VOLUME = 0;  // class attribute to be used by helper

    /**
     * Version B
     * This method no longer needs to generate a peak list, but to recursive check in-place
     */
    public int trap(int[] height) {

        int peak_idx = this.find_max_idx(height, 0, height.length);
        this.trap_helper(height, 0, peak_idx, peak_idx);
        this.trap_helper(height, peak_idx+1, height.length, peak_idx);
        int ans = this.VOLUME;
        this.VOLUME = 0;  // reset to zero for next run
        return ans;
    }

    /**
     * Helper B1: find out the max idx
     */
    private Integer find_max_idx(int[] height, int start, int end) {
        int max_so_far = -1;
        int max_idx = -1;
        for (int i = start; i < end; i += 1) {
            if (height[i] > max_so_far) {
                max_so_far = height[i];
                max_idx = i;
            }
        }
        return max_idx;
    }

    /**
     * Helper B2: recursively calcualte the volume between two peaks, bidirectional search
     */
    private void trap_helper(int[] height, int start, int end, int cur_max_idx) {
        if (end - start >= 1) {
            int new_max_idx = this.find_max_idx(height, start, end);
            if (new_max_idx < cur_max_idx) {
                for (int i = new_max_idx; i < cur_max_idx; i += 1) {
                    this.VOLUME += (height[new_max_idx] - height[i]);
                }
                this.trap_helper(height, 0, new_max_idx, new_max_idx); // sweeping to head

            } else {
                for (int i = cur_max_idx + 1; i < new_max_idx; i += 1) {
                    this.VOLUME += (height[new_max_idx] - height[i]);
                }
                this.trap_helper(height, new_max_idx + 1, height.length, new_max_idx); // sweeping to end
            }
        }
    }


    public static void main(String[] args) {
        LC042_Trapping_Rain_Water testCase = new LC042_Trapping_Rain_Water();

        int[] q1 = {};
        assert testCase.trap(q1) == 0 : "Edge 1";

        int[] q2 = {0};
        assert testCase.trap(q2) == 0 : "Edge 2";

        int[] q3 = {1};
        assert testCase.trap(q3) == 0 : "Edge 3";

        int[] q4 = {1, 1};
        assert testCase.trap(q4) == 0 : "Edge 4";

        int[] q5 = {2, 2, 2};
        assert testCase.trap(q5) == 0 : "Edge 5";

        int[] q6 = {2, 0, 2};
        assert testCase.trap(q6) == 2 : "Edge 6";

        int[] q7 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assert testCase.trap(q7) == 6 : "Example 1";

        int[] q8 = {10, 1, 2, 1, 2, 1, 10};
        assert testCase.trap(q8) == 43 : "Example 2";

        int[] q9 = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
        assert testCase.trap(q9) == 23 : "Example 3";

        int[] q10 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assert testCase.trap(q10) == 6 : "Extra 1";

        int[] q11 = {8, 5, 4, 1, 8, 9, 3, 0, 0};
        assert testCase.trap(q11) == 14 : "Extra 2";

        System.out.println("all passed");
    }
}

