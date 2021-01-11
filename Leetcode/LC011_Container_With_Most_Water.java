/**
 * https://leetcode.com/problems/container-with-most-water/
 * P011 Container with Most Water
 * Medium
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0)
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
class LC011_Container_With_Most_Water {

    /**
     * Version C
     * Start from both end, move the shorter side closer, to compare the possibe volume
     * Time O(N) Space O(1) locked, best answer
     */
    public int maxArea(int[] height) {

        int max_area = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            max_area = Math.max(max_area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        return max_area;
    }

    public static void main(String[] args) {
        LC011_Container_With_Most_Water testCase = new LC011_Container_With_Most_Water();

        int[] q1 = new int[]{0, 0};
        assert testCase.maxArea(q1) == 0 : "Edge 1";

        int[] q2 = new int[]{0, 0, 0};
        assert testCase.maxArea(q2) == 0 : "Edge 2";

        int[] q3 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        assert testCase.maxArea(q3) == 49 : "Example 1";

        int[] q4 = new int[]{2, 3, 0, 0, 3, 0, 0, 0, 0, 2};
        assert testCase.maxArea(q4) == 18 : "Example 2";

        int[] q5 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 100, 100};
        assert testCase.maxArea(q5) == 100 : "Example 3";

        int[] q6 = new int[]{1, 1, 1, 1, 1, 10, 10, 1, 1, 1, 1, 1};
        assert testCase.maxArea(q6) == 11 : "Example 4";

        int[] q7 = new int[]{1, 1, 4, 1, 5, 5, 4, 1, 1, 1};
        assert testCase.maxArea(q7) == 16 : "Example 5";

        System.out.println("All passed");
    }
}
