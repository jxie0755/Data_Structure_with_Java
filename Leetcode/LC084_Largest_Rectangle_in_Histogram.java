import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * Version A
     */
    // public int largestRectangleArea(int[] heights) {
    //     int N = heights.length;
    //
    //     int lowest_idx = 0;
    //     int lowest = Integer.MAX_VALUE;
    //
    //     if (N == 0) {
    //         return 0;
    //     } else if (N == 1) {
    //         return heights[0];
    //     } else {
    //         for (int i = 0; i < N; i++) {
    //             if (heights[i] < lowest) {
    //                 lowest = heights[i];
    //                 lowest_idx = i;
    //             }
    //         }
    //         int area = lowest * N;
    //         int[] first = Arrays.copyOfRange(heights, 0, lowest_idx);
    //         int[] second = Arrays.copyOfRange(heights, lowest_idx + 1, N);
    //         List<Integer> sample = new ArrayList<>(Arrays.asList(area, this.largestRectangleArea(first), this.largestRectangleArea(second)));
    //         return Collections.max(sample);
    //     }
    // }

    /**
     * STD method
     */
    public int largestRectangleArea(int[] heights) {
        List<Integer> increasing = new ArrayList<>(Arrays.asList());
        int area = 0;
        int i = 0;

        while (i <= heights.length) {
            if (increasing.size() == 0 || i < heights.length && heights[i] > heights[increasing.get(increasing.size() - 1)]) {
                increasing.add(i);
                i += 1;
            } else {
                int last = increasing.remove(increasing.size() - 1);
                if (increasing.size() == 0) {
                    area = Math.max(area, heights[last] * i);
                } else {
                    area = Math.max(area, heights[last] * (i - (increasing.get(increasing.size() - 1)) - 1));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LC084_Largest_Rectangle_in_Histogram testCase = new LC084_Largest_Rectangle_in_Histogram();
        assert testCase.largestRectangleArea(new int[]{}) == 0 : "Empty";
        assert testCase.largestRectangleArea(new int[]{2}) == 2 : "Edge 1";
        assert testCase.largestRectangleArea(new int[]{1, 2}) == 2 : "Edge 2";

        assert testCase.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) == 10 : "Example 1";

        assert testCase.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4}) == 10 : "Additional 1";
        assert testCase.largestRectangleArea(new int[]{0, 2, 0}) == 2 : "Additional 2";

        int[] long_array = new int[2000];
        for (int i = 0; i < 2000; i += 1) {
            long_array[i] = i;
        }
        assert testCase.largestRectangleArea(long_array) == 1000000 : "Extralong";

        System.out.println("All passed");
    }
}
