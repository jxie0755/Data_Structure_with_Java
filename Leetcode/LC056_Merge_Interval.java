import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * P056 Merge Intervals
 * Medium
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 */
class LC056_Merge_Interval {

    /**
     * Version A1 modified
     * Convert to a List<int[]> first
     * then sort and connect the two neighbored interval if possible
     * finally convert back to int[][]
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
                first[1] = Math.max(first[1], second[1]); // necessary, because [1,4] will be sorted before [2,3]
                itvlist.remove(i + 1);
            } else {
                i += 1;
            }
        }

        // convert back to int[][]
        return itvlist.toArray(new int[itvlist.size()][]);
    }

    public static void main(String[] args) {
        LC056_Merge_Interval testCase = new LC056_Merge_Interval();

        int[][] E0 = {{0, 1}};
        assert Arrays.deepEquals(
                testCase.merge(E0),
                new int[][]{{0, 1}}
        );

        int[][] S1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        assert Arrays.deepEquals(
                testCase.merge(S1),
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
        );

        int[][] S1B = {{15, 18}, {1, 3}, {8, 10}, {2, 6}};  // unsorted of S1
        assert Arrays.deepEquals(
                testCase.merge(S1B),
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
        );

        int[][] S2 = {{1, 4}, {4, 5}};
        assert Arrays.deepEquals(
                testCase.merge(S2),
                new int[][]{{1, 5}}
        );

        System.out.println("all passed");
    }
}

