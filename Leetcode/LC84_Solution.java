import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC84_Solution {
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
        int[] s1 = new int[]{4, 2, 0, 3, 2, 4, 3, 4};
        LC84_Solution Q1 = new LC84_Solution();
        assert Q1.largestRectangleArea(s1) == 10;
        System.out.println("all passed");
    }
}



