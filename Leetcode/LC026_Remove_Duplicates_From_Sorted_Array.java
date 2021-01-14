import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * p026 Remove duplicates from sorted array
 * Easy
 * <p>
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 意思是不能再造一个新list,而是在原list上改动
 */
class LC026_Remove_Duplicates_From_Sorted_Array {

    /**
     * Version A
     */
    public int removeDuplicates(int[] nums) {

        int check = Integer.MAX_VALUE;
        int length = 0;
        int new_idx = 0;

        for (int i = 1; i < nums.length; i += 1) {
            int cur = nums[i];
            if (cur != check) {
                nums[new_idx] = cur;
                check = cur;
                length += 1;
                new_idx += 1;
            }
        }

        return length;
        // 注意, 这里不会减少array长度, 只是把不重复的元素位置提前了, 返回的是新的去重后的计算长度
    }


    public static void main(String[] args) {
        LC026_Remove_Duplicates_From_Sorted_Array testCase = new LC026_Remove_Duplicates_From_Sorted_Array();

        int[] Q0 = new int[]{};
        assert testCase.removeDuplicates(Q0) == 0 : "Edge 0";
        assert Arrays.equals(Q0, new int[]{}) : "Empty 0 list";

        int[] Q1 = new int[]{1, 1};
        assert testCase.removeDuplicates(Q1) == 1 : "Edge 1";
        assert Arrays.equals(Q1, new int[]{1, 1}) : "Edge 1 revised list";

        int[] Q2 = new int[]{1, 1, 2, 2, 3};
        assert testCase.removeDuplicates(Q2) == 3 : "Example 1";
        assert Arrays.equals(Q2, new int[]{1, 2, 3, 2, 3}) : "Example 1 revised list";

        System.out.println("All passed");
    }
}

