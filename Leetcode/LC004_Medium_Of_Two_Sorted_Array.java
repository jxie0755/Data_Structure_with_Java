
/**
 * P004 Median of Two Sorted Array
 * Hard
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class LC004_Medium_Of_Two_Sorted_Array {

    /**
     * Version C2, Time O(N), space O(1/2N)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total_length = nums1.length + nums2.length;
        int mid_idx = total_length / 2;

        int i1 = 0;
        int i2 = 0;
        int ct = 0;
        int pre = 0;
        int cur = 0;

        while (true) {

            if (i1 == nums1.length) {
                cur = nums2[i2];
                i2 += 1;
            } else if (i2 == nums2.length) {
                cur = nums1[i1];
                i1 += 1;
            } else if (nums1[i1] <= nums2[i2]) {
                cur = nums1[i1];
                i1 += 1;
            } else {
                cur = nums2[i2];
                i2 += 1;
            }

            if (ct < mid_idx) {
                pre = cur;
                ct += 1;
            } else {
                break;
            }
        }

        if (total_length % 2 == 0) {
            return ((double) cur + pre) / 2;
        }
        return (double) cur;

    }

    public static void main(String[] args) {

        int[] a1 = new int[]{};
        int[] a2 = new int[]{1};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(a1, a2) == 1.0 : "Edge 1";

        int[] b1 = new int[]{2};
        int[] b2 = new int[]{};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(b1, b2) == 2.0 : "Edge 2";

        int[] c1 = new int[]{1};
        int[] c2 = new int[]{2};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(c1, c2) == 1.5 : "Edge 3";

        int[] d1 = new int[]{1, 3};
        int[] d2 = new int[]{2};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(d1, d2) == 2.0 : "Example 1";

        int[] e1 = new int[]{1, 2};
        int[] e2 = new int[]{3, 4};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(e1, e2) == 2.5 : "Example 2";

        int[] f1 = new int[]{1, 2, 3, 4};
        int[] f2 = new int[]{2, 3, 4, 5};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(f1, f2) == 3.0 : "Example 3";

        int[] g1 = new int[]{3};
        int[] g2 = new int[]{-2, -1};
        assert new LC004_Medium_Of_Two_Sorted_Array().findMedianSortedArrays(g1, g2) == -1.0 : "Negative";

        System.out.println("all passed");
    }
}

