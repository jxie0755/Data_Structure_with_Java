import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-intervals/
 * P056 Merge Intervals
 * Medium
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class LC056_Merge_Interval {

    public int[][] merge(int[][] intervals) {

    }

    public static void main(String[] args) {

        int[][] E0 = {{0, 1}};
        assert Arrays.deepEquals(
                new LC056_Merge_Interval().merge(E0),
                new int[][]{{0, 1}}
        );

        int[][] S1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};


    }
}

