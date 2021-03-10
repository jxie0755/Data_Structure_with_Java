
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * LC004 Median of Two Sorted Array
 * Hard
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
class LC004_Medium_Of_Two_Sorted_Array {

    /**
     * Version B2, Time O(N), space O(1)
     * MergeSort like, Same half way method with but only keep tracking the last two in the merge_list
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double ans;

        int L1 = nums1.length;
        int L2 = nums2.length;
        int total_length = L1 + L2;

        int i1 = 0;
        int i2 = 0;

        int n = 0;

        int[] merge_list = new int[2];

        while (n != total_length / 2 + 1) {

            merge_list[0] = merge_list[1];

            int v1;
            int v2;

            if (i1 < L1) {
                v1 = nums1[i1];
            } else {
                v1 = Integer.MAX_VALUE;
            }

            if (i2 < L2) {
                v2 = nums2[i2];
            } else {
                v2 = Integer.MAX_VALUE;
            }

            if (v1 <= v2) {
                merge_list[1] = v1;
                i1 += 1;
            } else {
                merge_list[1] = v2;
                i2 += 1;
            }

            n += 1;

        }

        if (total_length % 2 == 0) {
            ans = (double) (merge_list[0] + merge_list[1]) / 2;
        } else {
            ans = (double) merge_list[1];
        }
        return ans;

    }

    public static void main(String[] args) {
        LC004_Medium_Of_Two_Sorted_Array testCase = new LC004_Medium_Of_Two_Sorted_Array();

        int[] a1 = new int[]{};
        int[] a2 = new int[]{1};
        assert testCase.findMedianSortedArrays(a1, a2) == 1.0 : "Edge 0";

        int[] b1 = new int[]{2};
        int[] b2 = new int[]{};
        assert testCase.findMedianSortedArrays(b1, b2) == 2.0 : "Empty 00";

        int[] c1 = new int[]{1};
        int[] c2 = new int[]{2};
        assert testCase.findMedianSortedArrays(c1, c2) == 1.5 : "Edge 1";

        int[] d1 = new int[]{1, 3};
        int[] d2 = new int[]{2};
        assert testCase.findMedianSortedArrays(d1, d2) == 2.0 : "Example 1";

        int[] e1 = new int[]{1, 2};
        int[] e2 = new int[]{3, 4};
        assert testCase.findMedianSortedArrays(e1, e2) == 2.5 : "Example 2";

        int[] f1 = new int[]{1, 2, 3, 4};
        int[] f2 = new int[]{2, 3, 4, 5};
        assert testCase.findMedianSortedArrays(f1, f2) == 3.0 : "Example 3";

        int[] g1 = new int[]{3};
        int[] g2 = new int[]{-2, -1};
        assert testCase.findMedianSortedArrays(g1, g2) == -1.0 : "Negative";

        System.out.println("All passed");
    }
}
