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
     * Version B
     * insert the new interval at the right location of already sorted intervals
     * then skip the sorting and just merge
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int[][] combined_intervals = new int[intervals.length + 1][];
        int i = 0;
        while (i != intervals.length) {
            if (intervals[i][0] < newInterval[0]) {
                combined_intervals[i] = intervals[i];
                i += 1;
            } else {
                break;
            }
        }
        combined_intervals[i] = newInterval;
        while (i != intervals.length) {
            combined_intervals[i + 1] = intervals[i];
            i += 1;
        }

        return this.merge(combined_intervals);
    }

    /**
     * Helper modified from LC056
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }

        // convert to list
        List<int[]> itvlist = new ArrayList<>(Arrays.asList(intervals));

        // sort list is skipped
        // itvlist.sort((o1, o2) -> o1[0] - o2[0]);

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
        ) : "Edge 0";

        int[][] E1 = {{1, 5}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(E1, new int[]{2, 3}),
                new int[][]{{1, 5}}
        ) : "Edge 1";

        int[][] E2 = {{1, 5}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(E2, new int[]{2, 7}),
                new int[][]{{1, 7}}
        ) : "Edge 3";

        int[][] S1 = {{1, 3}, {6, 9}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S1, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        ) : "Example 1";

        int[][] S2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S2, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        ) : "Example 2";

        int[][] S2B = {{1, 2}, {3, 7}, {4, 6}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                new LC057_Insert_Interval().insert(S2B, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        ) : "Example 2 extended";

        System.out.println("all passed");
    }
}

