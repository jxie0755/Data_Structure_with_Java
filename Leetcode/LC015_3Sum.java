import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P015 3Sum
 * Medium
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 */
public class LC015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

    }

    public static void main(String[] args) {

        List<Integer> a11 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList(a11));
        assert new LC015_3Sum().threeSum(new int[]{}).equals(a1): "Edge 1";

        List<Integer> a21 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList(a21));
        assert new LC015_3Sum().threeSum(new int[]{1}).equals(a2): "Edge 2";

        List<Integer> a31 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList(a31));
        assert new LC015_3Sum().threeSum(new int[]{1,1}).equals(a3): "Edge 3";

        List<Integer> a41 = new ArrayList<>(Arrays.asList(-1, -1, 2));
        List<Integer> a42 = new ArrayList<>(Arrays.asList(-1, 0, 1));
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList(a41, a42));
        assert new LC015_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}).equals(a4): "Example 1";

        List<Integer> a51 = new ArrayList<>(Arrays.asList(-4, -2, 6));
        List<Integer> a52 = new ArrayList<>(Arrays.asList(-4, 0, 4));
        List<Integer> a53 = new ArrayList<>(Arrays.asList(-4, 1, 3));
        List<Integer> a54 = new ArrayList<>(Arrays.asList(-4, 2, 2));
        List<Integer> a55 = new ArrayList<>(Arrays.asList(-2, -2, 4));
        List<Integer> a56 = new ArrayList<>(Arrays.asList(-2, 0, 2));

        List<List<Integer>> a5 = new ArrayList<>(Arrays.asList(a51, a52, a53, a54, a55, a56));
        assert new LC015_3Sum().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}).equals(a5): "Example 2";

        List<Integer> a61 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> a6 = new ArrayList<>(Arrays.asList(a61));
        assert new LC015_3Sum().threeSum(new int[]{-4,-2,-1}).equals(a6): "Example 3";

        List<Integer> a71 = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<List<Integer>> a7 = new ArrayList<>(Arrays.asList(a71));
        assert new LC015_3Sum().threeSum(new int[]{0, 0, 0}).equals(a7): "Example 4";

        System.out.println("all passed");
    }

}

