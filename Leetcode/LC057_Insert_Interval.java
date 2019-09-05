import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * P057 Insert Interval
 * Hard
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class LC057_Insert_Interval {

    /**
     * Version A
     * Add the new interval to the intervals at the end and let it merge
     * Merge process will automatically sort and merge
     * This could be slow as the sorting is complicated
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] new_intervals = Arrays.copyOf(intervals, intervals.length + 1);
        new_intervals[intervals.length] = newInterval;
        return this.merge(new_intervals);
    }

    /**
     * Helper from LC056
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }

        // convert to list
        List<int[]> itvlist = new ArrayList<>(Arrays.asList(intervals));

        // sort list
        itvlist.sort((o1, o2) -> o1[0] - o2[0]);

        int i = 0;
        while (i != itvlist.size() - 1) {
            int[] first = itvlist.get(i);
            int[] second = itvlist.get(i + 1);
            if (first[1] >= second[0]) {
                first[1] = Math.max(first[1], second[1]);
                itvlist.remove(i + 1);
            } else {
                i += 1;
            }
        }

        // convert back to int[][]
        return itvlist.toArray(new int[itvlist.size()][]);
    }

    public static void main(String[] args) {
        int[][] E0 = {};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(E0, new int[]{1, 2}),
                new int[][]{{1, 2}}
        );

        int[][] S1 = {{1, 3}, {6, 9}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S1, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        );

        int[][] S2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S2, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        );

        int[][] S2B = {{1, 2}, {3, 7}, {4, 6}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S2B, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        );

        System.out.println("all passed");
    }
}

