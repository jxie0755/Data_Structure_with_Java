import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
class LC041_First_Missing_Positive {


    /**
     * Version A
     * O(N), space O(N) (not constant space)
     */
    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }

        List<Integer> all_int = new ArrayList<>(Arrays.asList());
        for (int i = 1; i <= nums.length; i += 1) {
            all_int.add(i);
        }

        for (int e : nums) {
            all_int.remove(Integer.valueOf(e));
        }

        if (all_int.size() == 0) {
            return nums.length + 1;
        } else {
            return all_int.get(0);
        }
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

