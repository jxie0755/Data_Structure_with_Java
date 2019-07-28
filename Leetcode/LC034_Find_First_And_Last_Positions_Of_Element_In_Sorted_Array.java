import java.util.Arrays;

/**
 * P033 Find First and Last Positions of Element in Sorted Array
 * Medium
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1]
 */
public class LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array {

    /**
     * Version B
     * improved binary search
     * 3 binary search, find catch mid value, and Low/High of the section,
     * Then according to mid value and Low/High to find head and tail by 2 additional binary search
     * O(LogN), Space O(1)
     */
    public int[] searchRange(int[] nums, int target) {

    }

    public static void main(String[] args) {

        int[] Q1 = new int[]{};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q1, 8),
                new int[]{-1, -1})
                : "Edge 1";

        int[] Q2 = new int[]{8};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q2, 8),
                new int[]{0, 0})
                : "Edge 2";

        int[] Q3 = new int[]{0};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q3, 8),
                new int[]{-1, -1})
                : "Edge 3";

        int[] Q4 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q4, 8),
                new int[]{3, 4})
                : "Example 1";

        int[] Q5 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q5, 6),
                new int[]{-1, -1})
                : "Example 2";

        int[] Q6 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q6, 8),
                new int[]{4, 4})
                : "Additional 1";

        int[] Q7 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q7, 7),
                new int[]{1, 3})
                : "Additional 2";

        int[] Q8 = new int[]{1, 4};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q8, 4),
                new int[]{1, 1})
                : "Extra 1";

        int[] Q9 = new int[]{1, 3};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q9, 1),
                new int[]{0, 0})
                : "Extra 2";

        int[] Q10 = new int[]{-3, -2, -1};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q10, 0),
                new int[]{-1, -1})
                : "Extra 3";

        int[] Q11 = new int[]{0, 0, 2, 3, 4, 4, 4, 5};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q11, 5),
                new int[]{7, 7})
                : "Extra 4";

        int[] Q12 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q12, 4),
                new int[]{10, 13})
                : "Extra 5";

        int[] Q13 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q13, 4),
                new int[]{10, 13})
                : "Extra 5";

    }
}

