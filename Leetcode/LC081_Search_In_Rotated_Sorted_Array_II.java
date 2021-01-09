import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * P081 Search in Rotated Sorted Array II
 * Medium
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * <p>
 * before: [0,1,2,3,4,5,6] might become [3,4,5,6,0,1,2]).
 * now:    [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]
 */
class LC081_Search_In_Rotated_Sorted_Array_II {

    /**
     * Version A
     */
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2 + 1;
        int[] first = Arrays.copyOfRange(nums, 0, mid);
        int[] second = Arrays.copyOfRange(nums, mid, nums.length);

        boolean A = this.isSortedQuick(first);
        boolean B = this.isSortedQuick(second);

        if (A && B) {
            return this.binarySearch(first, target) || this.binarySearch(second, target);
        } else if (A) {
            return this.binarySearch(first, target) || this.search(second, target);
        } else {
            return this.binarySearch(second, target) ||this.search(first, target);
        }
    }

    /**
     * Helper function to binary search if an target is in sorted array
     */
    private boolean binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    /**
     * Helpfer function specialized for this question
     * To Tell if an array is sorted
     */
    private boolean isSortedQuick(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != nums[0]) {
                if (nums[0] < nums[nums.length - 1]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC081_Search_In_Rotated_Sorted_Array_II testCase = new LC081_Search_In_Rotated_Sorted_Array_II();
        assert testCase.search(new int[]{1}, 1) : "Edge 1";
        assert testCase.search(new int[]{1, 1}, 1) : "Edge 2";
        assert !testCase.search(new int[]{3, 1}, 0) : "Edge 3";
        assert testCase.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0) : "Example 1";
        assert !testCase.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3) : "Example 2";
        assert testCase.search(new int[]{1, 3, 1, 1, 1}, 3) : "Additional 1";
        assert testCase.search(new int[]{3, 1}, 1) : "Additional 2";
        assert !testCase.search(new int[]{1, 3, 5}, 0) : "Additional 3";
        assert !testCase.search(new int[]{0, 1, 2, 3, 3, 3}, 4) : "Additional 4";
        System.out.println("all passed");
    }
}

