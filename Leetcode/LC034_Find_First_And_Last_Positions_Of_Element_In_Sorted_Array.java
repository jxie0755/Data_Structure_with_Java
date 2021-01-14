import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * P033 Find First and Last Positions of Element in Sorted Array
 * Medium
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1]
 */
class LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array {

    /**
     * Version A
     * improved binary search
     * 3 binary search, find catch mid value, and Low/High of the section,
     * Then according to mid value and Low/High to find head and tail by 2 additional binary search
     * O(LogN), Space O(1)
     */
    public int[] searchRange(int[] nums, int target) {

        int L = 0;
        int H = nums.length - 1;
        int M = (L + H) / 2;
        boolean target_found = false;


        // first while loop to find whether target is in the Array
        while (L <= H) {
            M = (L + H) / 2;
            if (nums[M] < target) {
                L = M + 1;
            } else if (nums[M] > target) {
                H = M - 1;
            } else {
                target_found = true;
                break;
            }
        }

        if (!target_found) {
            return new int[]{-1, -1};
        }

        int head = M;
        int tail = M;

        // locate head
        while (true) {
            M = (L + head) / 2;

            if (nums[L] == target) {
                head = L;
                break;
            } else if (nums[M] < target) {
                L = M + 1;
            } else {
                head = M;
                if (nums[M - 1] != target) {
                    break;
                }
            }
        }

        // locate head
        while (true) {
            M = (tail + H) / 2;

            if (nums[H] == target) {
                tail = H;
                break;
            } else if (nums[M] > target) {
                H = M - 1;
            } else {
                tail = M;
                if (nums[M + 1] != target) {
                    break;
                }
            }
        }

        return new int[]{head, tail};
    }

    public static void main(String[] args) {
        LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array testCase = new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array();

        int[] Q1 = new int[]{};
        assert Arrays.equals(
                testCase.searchRange(Q1, 0),
                new int[]{-1, -1})
                : "Edge 0";

        int[] Q2 = new int[]{8};
        assert Arrays.equals(
                testCase.searchRange(Q2, 8),
                new int[]{0, 0})
                : "Edge 1";

        int[] Q3 = new int[]{0};
        assert Arrays.equals(
                testCase.searchRange(Q3, 8),
                new int[]{-1, -1})
                : "Edge 2";

        int[] Q4 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                testCase.searchRange(Q4, 8),
                new int[]{3, 4})
                : "Example 1";

        int[] Q5 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                testCase.searchRange(Q5, 6),
                new int[]{-1, -1})
                : "Example 2";

        int[] Q6 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                testCase.searchRange(Q6, 8),
                new int[]{4, 4})
                : "Additional 1";

        int[] Q7 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                testCase.searchRange(Q7, 7),
                new int[]{1, 3})
                : "Additional 2";

        int[] Q8 = new int[]{1, 4};
        assert Arrays.equals(
                testCase.searchRange(Q8, 4),
                new int[]{1, 1})
                : "Additional 1";

        int[] Q9 = new int[]{1, 3};
        assert Arrays.equals(
                testCase.searchRange(Q9, 1),
                new int[]{0, 0})
                : "Additional 2";

        int[] Q10 = new int[]{-3, -2, -1};
        assert Arrays.equals(
                testCase.searchRange(Q10, 0),
                new int[]{-1, -1})
                : "Additional 3";

        int[] Q11 = new int[]{0, 0, 2, 3, 4, 4, 4, 5};
        assert Arrays.equals(
                testCase.searchRange(Q11, 5),
                new int[]{7, 7})
                : "Additional 4";

        int[] Q12 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        assert Arrays.equals(
                testCase.searchRange(Q12, 4),
                new int[]{10, 13})
                : "Additional 5";

        int[] Q13 = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9};
        assert Arrays.equals(
                testCase.searchRange(Q13, 3),
                new int[]{2, 5})
                : "Additional 6";

        System.out.println("All passed");
    }
}

