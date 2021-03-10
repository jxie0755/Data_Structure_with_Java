import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * LC088 Merge Sorted Array
 * Easy
 * <p>
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Key is to modified nums1, not returning a new list
 */
class LC088_Merge_Sorted_Array {

    /**
     * Version B1, treat as true array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged_idx = 0;
        int nums2_idx = 0;
        while (merged_idx != m + n && nums2_idx != n) {
            int cur = nums1[merged_idx];
            int check = nums2[nums2_idx];
            if (check <= cur || merged_idx == m + nums2_idx) {
                for (int x = merged_idx + 1; x < m + n; x += 1) {
                    int tmp = nums1[x];
                    nums1[x] = nums1[merged_idx];
                    nums1[merged_idx] = tmp;
                }
                nums1[merged_idx] = check;
                nums2_idx += 1;
            }
            merged_idx += 1;
        }
    }

    public static void main(String[] args) {
        LC088_Merge_Sorted_Array testCase = new LC088_Merge_Sorted_Array();

        int[] q1a = new int[]{1};
        int[] q1b = new int[]{};
        testCase.merge(q1a, 1, q1b, 0);
        assert Arrays.equals(q1a, new int[]{1}) : "T1";

        int[] q2a = new int[]{0};
        int[] q2b = new int[]{1};
        testCase.merge(q2a, 0, q2b, 1);
        assert Arrays.equals(q2a, new int[]{1}) : "T2";

        int[] q3a = new int[]{1, 2, 3, 0, 0, 0};
        int[] a3b = new int[]{2, 5, 6};
        testCase.merge(q3a, 3, a3b, 3);
        assert Arrays.equals(q3a, new int[]{1, 2, 2, 3, 5, 6}) : "T3";

        int[] q4a = new int[]{1, 5, 7, 0, 0, 0};
        int[] q4b = new int[]{2, 4, 10};
        testCase.merge(q4a, 3, q4b, 3);
        assert Arrays.equals(q4a, new int[]{1, 2, 4, 5, 7, 10}) : "T4";

        int[] q5a = new int[]{8, 8, 8, 0, 0, 0};
        int[] q5b = new int[]{1, 2, 3};
        testCase.merge(q5a, 3, q5b, 3);
        assert Arrays.equals(q5a, new int[]{1, 2, 3, 8, 8, 8}) : "T5";

        int[] q6a = new int[]{1, 0, 0, 0};
        int[] q6b = new int[]{5, 5, 5};
        testCase.merge(q6a, 1, q6b, 3);
        assert Arrays.equals(q6a, new int[]{1, 5, 5, 5}) : "T6";

        int[] q7a = new int[]{1, 2, 4, 5, 6, 0};
        int[] q7b = new int[]{3};
        testCase.merge(q7a, 5, q7b, 1);
        assert Arrays.equals(q7a, new int[]{1, 2, 3, 4, 5, 6}) : "T7";

        int[] q8a = new int[]{4, 0, 0, 0, 0, 0};
        int[] q8b = new int[]{1, 2, 3, 5, 6};
        testCase.merge(q8a, 1, q8b, 5);
        assert Arrays.equals(q8a, new int[]{1, 2, 3, 4, 5, 6}) : "T8";

        int[] q9a = new int[]{4, 0, 0, 0, 0, 0, 0};
        int[] q9b = new int[]{1, 2, 3, 5, 6};
        testCase.merge(q9a, 1, q9b, 5);
        assert Arrays.equals(q9a, new int[]{1, 2, 3, 4, 5, 6, 0}) : "T9";

        int[] q10a = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] q10b = new int[]{1, 2, 2};
        testCase.merge(q10a, 6, q10b, 3);
        assert Arrays.equals(q10a, new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 3}) : "T10";

        System.out.println("All passed");
    }
}

