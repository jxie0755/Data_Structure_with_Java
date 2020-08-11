/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
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
class LC033_Search_In_Rotated_Sorted_Array {


    /**
     * Version B
     * Regular while loop, binary search O(logN) * c
     */
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int L = 0;
        int H = nums.length - 1;

        while (L <= H) {
            int M = (L + H) / 2;
            int low = nums[L];
            int mid = nums[M];
            int high = nums[H];

            if (mid == target) {
                return M;
            }

            if (L == H) {
                if (low == target) {
                    return L;
                } else {
                    return -1;
                }
            }

            if (low <= target && target <= mid) {
                H = M - 1;
            } else if (mid <= target && target <= high) {
                L = M + 1;
            } else if (low > mid) {
                H = M - 1;
            } else if (mid >= low) {
                L = M + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC033_Search_In_Rotated_Sorted_Array testCase = new LC033_Search_In_Rotated_Sorted_Array();

        int[] Q1 = new int[]{0};
        assert testCase.search(Q1, 1) == -1 : "Edge 1";

        int[] Q2 = new int[]{1};
        assert testCase.search(Q2, 1) == 0 : "Edge 2";

        int[] Q3 = new int[]{0};
        assert testCase.search(Q3, 1) == -1 : "Edge 3";

        int[] Q4 = new int[]{4, 5, 6, 7, 0, 1, 2};
        assert testCase.search(Q4, 0) == 4 : "Example 1";

        int[] Q5 = new int[]{4, 5, 6, 7, 0, 1, 2};
        assert testCase.search(Q5, 3) == -1 : "Example 2";

        int[] E1 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E1, 3) == 0 : "Additional 1";

        int[] E2 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E2, 4) == 1 : "Additional 2";

        int[] E3 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E3, 8) == 5 : "Additional 3";

        int[] E4 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E4, 10) == 7 : "Additional 4";

        int[] E5 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E5, 1) == 8 : "Additional 5";

        int[] E6 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        assert testCase.search(E6, 2) == 9 : "Additional 6";

        int[] E7 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert testCase.search(E7, 8) == 0 : "Additional 7";

        int[] E8 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert testCase.search(E8, 1) == 3 : "Additional 8";

        int[] E9 = new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        assert testCase.search(E9, 6) == 8 : "Additional 9";

        System.out.println("all passed");
    }

}

