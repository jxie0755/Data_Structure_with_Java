/**
 * P033 Search in Rotated Sorted Array
 * Medium
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class LC033_Search_In_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {

    }

    public static void main(String[] args) {

        int[] Q1 = new int[]{};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(Q1, 1) == -1 : "Edge 1";

        int[] Q2 = new int[]{1};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(Q2, 0) == 0 : "Edge 2";

        int[] Q3 = new int[]{0};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(Q3, 0) == -1 : "Edge 3";

        int[] Q4 = new int[]{4, 5, 6, 7, 0, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(Q4, 0) == 4 : "Example 1";

        int[] Q5 = new int[]{4, 5, 6, 7, 0, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(Q5, 3) == -1 : "Example 2";

        int[] E1 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E1, 3) == 0 : "Additional 1";

        int[] E2 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E2, 4) == 1 : "Additional 2";

        int[] E3 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E3, 8) == 5 : "Additional 3";

        int[] E4 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E4, 10) == 7 : "Additional 4";

        int[] E5 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E5, 1) == 8 : "Additional 5";

        int[] E6 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E6, 2) == 9 : "Additional 6";

        int[] E7 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E7, 8) == 0 : "Additional 7";

        int[] E8 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E8, 1) == 3 : "Additional 8";

        int[] E9 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert new LC033_Search_In_Rotated_Sorted_Array().search(E9, 6) == 8 : "Additional 9";

        System.out.println("all passed");
    }

}

