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
class LC057_Insert_Interval {

    /**
     * Version B
     * insert the new interval at the right location of already sorted intervals
     * then skip the sorting and just merge
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        // create a new int[] array combined_intervals with len+1
        // Then iterate intervals and add newIntervals with two while loops
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
        LC057_Insert_Interval testCase = new LC057_Insert_Interval();
        int[][] E0 = {};
        assert Arrays.deepEquals(
                testCase.insert(E0, new int[]{1, 2}),
                new int[][]{{1, 2}}
        ) : "Edge 0";

        int[][] E1 = {{1, 5}};
        assert Arrays.deepEquals(
                testCase.insert(E1, new int[]{2, 3}),
                new int[][]{{1, 5}}
        ) : "Edge 1";

        int[][] E2 = {{1, 5}};
        assert Arrays.deepEquals(
                testCase.insert(E2, new int[]{2, 7}),
                new int[][]{{1, 7}}
        ) : "Edge 3";

        int[][] S1 = {{1, 3}, {6, 9}};
        assert Arrays.deepEquals(
                testCase.insert(S1, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        ) : "Example 1";

        int[][] S2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                testCase.insert(S2, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        ) : "Example 2";

        int[][] S2B = {{1, 2}, {3, 7}, {4, 6}, {8, 10}, {12, 16}};
        assert Arrays.deepEquals(
                testCase.insert(S2B, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        ) : "Example 2 extended";

        int[][] Ex1 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex1, new int[]{1, 2}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 1";

        int[][] Ex2 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex2, new int[]{2, 3}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 2";

        int[][] Ex3 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex3, new int[]{3, 4}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 3";

        int[][] Ex4 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex4, new int[]{4, 5}),
                new int[][]{{1, 5}, {7, 10}}
        ) : "Additional 4";

        int[][] Ex5 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex5, new int[]{5, 6}),
                new int[][]{{1, 4}, {5, 6}, {7, 10}}
        ) : "Additional 5";

        int[][] Ex6 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex6, new int[]{6, 7}),
                new int[][]{{1, 4}, {6, 10}}
        ) : "Additional 6";

        int[][] Ex7 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex7, new int[]{7, 8}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 7";

        int[][] Ex8 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex8, new int[]{8, 9}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 8";

        int[][] Ex9 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex9, new int[]{9, 10}),
                new int[][]{{1, 4}, {7, 10}}
        ) : "Additional 9";

        int[][] Ex10 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex10, new int[]{10, 11}),
                new int[][]{{1, 4}, {7, 11}}
        ) : "Additional 10";

        int[][] Ex11 = {{1, 4}, {7, 10}};
        assert Arrays.deepEquals(
                testCase.insert(Ex11, new int[]{11, 12}),
                new int[][]{{1, 4}, {7, 10}, {11, 12}}
        ) : "Additional 11";

        System.out.println("All passed");
    }
}

