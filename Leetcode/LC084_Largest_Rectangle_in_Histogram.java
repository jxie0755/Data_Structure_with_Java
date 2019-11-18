import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * P084 Largest Rectangle in Histogram
 * Hard
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
class LC084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        int N = heights.length;

        int lowest_idx = 0;
        int lowest = Integer.MAX_VALUE;

        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return heights[0];
        } else {
            for (int i = 0; i < N; i++) {
                if (heights[i] < lowest) {
                    lowest = heights[i];
                    lowest_idx = i;
                }
            }
            int area = lowest * N;
            int[] first = Arrays.copyOfRange(heights, 0, lowest_idx);
            int[] second = Arrays.copyOfRange(heights, lowest_idx + 1, N);
            List<Integer> sample = new ArrayList<>(Arrays.asList(area, this.largestRectangleArea(first), this.largestRectangleArea(second)));
            return Collections.max(sample);
        }
    }

    public static void main(String[] args) {
        LC084_Largest_Rectangle_in_Histogram testCase = new LC084_Largest_Rectangle_in_Histogram();
        int[] s1 = new int[]{4, 2, 0, 3, 2, 4, 3, 4};
        LC084_Largest_Rectangle_in_Histogram Q1 = new LC084_Largest_Rectangle_in_Histogram();
        assert Q1.largestRectangleArea(s1) == 10;
        System.out.println("all passed");
    }
}
