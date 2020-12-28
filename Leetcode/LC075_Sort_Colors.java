import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * P075 Sort Colors
 * Medium
 * <p>
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0"s, 1"s, and 2"s, then overwrite array with total number of 0"s, then 1"s and followed by 2"s.
 * Could you come up with a one-pass algorithm using only constant space?
 */

public class LC075_Sort_Colors {

    /**
     * Version B
     * Array method by swapping, no need to change array length
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int L = nums.length;

        int head = 0;
        int tail = L - 1;

        while (i != L) {
            if (nums[i] == 0 && i > head) {
                nums[i] = nums[head];
                nums[head] = 0;
                head += 1;
            } else if (nums[i] == 2 && i < tail) {
                nums[i] = nums[tail];
                nums[tail] = 2;
                tail -= 1;
            } else {
                i += 1;
            }
        }
    }

    public static void main(String[] args) {
        LC075_Sort_Colors testCase = new LC075_Sort_Colors();

        int[] e1 = new int[]{};
        testCase.sortColors(e1);
        assert Arrays.equals(e1, new int[]{}) : "Edge 1";

        int[] e2 = new int[]{0, 0};
        testCase.sortColors(e2);
        assert Arrays.equals(e2, new int[]{0, 0}) : "Edge 2";

        int[] s1 = new int[]{2, 0, 2, 1, 1, 0};
        testCase.sortColors(s1);
        assert Arrays.equals(s1, new int[]{0, 0, 1, 1, 2, 2}) : "Example 1";

        int[] s2 = new int[]{0, 2, 1, 2, 0, 1, 2, 1};
        testCase.sortColors(s2);
        assert Arrays.equals(s2, new int[]{0, 0, 1, 1, 1, 2, 2, 2}) : "Addtional 1";

        int[] s3 = new int[]{1, 0};
        testCase.sortColors(s3);
        assert Arrays.equals(s3, new int[]{0, 1}) : "Addtional 2";

        System.out.println("all passed");
    }
}

