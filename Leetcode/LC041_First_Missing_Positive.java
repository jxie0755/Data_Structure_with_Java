/**
 * https://leetcode.com/problems/first-missing-positive/
 * P041 First Missing Positive
 * Hard
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class LC041_First_Missing_Positive {


    /**
     * Version A
     * O(N), space O(N)
     */
    public int firstMissingPositive(int[] nums) {

    }

    public static void main(String[] args) {
        int[] q1 = {};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q1) == 1 : "Edge 1";

        int[] q2 = {1};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q2) == 2 : "Edge 2";

        int[] q3 = {2};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q3) == 1 : "Edge 3";

        int[] q4 = {-1};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q4) == 1 : "Edge 4";

        int[] q5 = {1, 2, 0};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q5) == 3 : "Example 1";

        int[] q6 = {3, 4, -1, 1};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q6) == 2 : "Example 2";

        int[] q7 = {7, 8, 99, 11, 12};
        assert new LC041_First_Missing_Positive().firstMissingPositive(q7) == 1 : "Example 3";

        System.out.println("all passed");

    }

}

