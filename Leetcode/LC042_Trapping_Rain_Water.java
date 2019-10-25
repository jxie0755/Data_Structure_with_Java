import java.util.*;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * P042 Trapping Rain Water
 * Hard
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
class LC042_Trapping_Rain_Water {

    /**
     * Version A
     * According to the peak and find the volume in between
     */
    public int trap(int[] height) {

        List<Integer> peak_list = this.findPeaks(height);

        if (peak_list.size() <= 1) {
            return 0;
        }

        int start = Math.min(peak_list.get(0), peak_list.get(1));
        int end = Math.max(peak_list.get(0), peak_list.get(1));
        peak_list = peak_list.subList(2, peak_list.size());
        int volume = this.vol(Arrays.copyOfRange(height, start, end + 1));

        while (peak_list.size() != 0) {
            int next_peak_idx = peak_list.remove(0);
            if (next_peak_idx < start) {
                volume += this.vol(Arrays.copyOfRange(height, next_peak_idx, start + 1));
                start = next_peak_idx;
            } else if (next_peak_idx > end) {
                volume += this.vol(Arrays.copyOfRange(height, end, next_peak_idx + 1));
                end = next_peak_idx;
            } else {
                // pass
            }
        }

        return volume;
    }

    // Helper 1 - version A
    // Calculate the volume between two peaks
    private Integer vol(int[] height) {
        int sec_peak = Math.min(height[0], height[height.length - 1]);
        int volume = 0;
        for (int i : height) {
            if (i < sec_peak) {
                volume += sec_peak - i;
            }
        }
        return volume;
    }

    // Helper 2 - version A
    // To find the index of peaks, and sort reversely accoridng to the height value at the index
    private List<Integer> findPeaks(int[] height) {
        Map<Integer, Integer> hmp = new HashMap<>();

        int[] temp = new int[height.length + 2];
        temp[0] = 0;
        temp[height.length + 1] = 0;
        for (int i = 1; i < height.length + 1; i += 1) {
            temp[i] = height[i - 1];
        }

        for (int i = 0; i < height.length; i += 1) {
            int prev = temp[i];
            int mid = temp[i + 1];
            int aft = temp[i + 2];
            if (prev <= mid && mid >= aft) {
                hmp.put(i, mid);
            }
        }
        List<Integer> lst = new ArrayList<>(hmp.keySet());
        lst.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hmp.get(o1) - hmp.get(o2);
            }
        });
        Collections.reverse(lst);
        return lst;
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

        System.out.println("all passed");
    }
}

