import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * P080 Remove Duplicates from Sorted Array II
 * Medium
 * <p>
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class LC080_Remove_Duplicates_From_Sorted_Array_II {

    /**
     * Version C, Space O(1) using single element hash table
     * Need special handling with Array, set it to None (as the length won't change)
     */
    public int removeDuplicates(int[] nums) {
        int check_idx = 0;
        int idx = 0;
        Map<Integer, Integer> hmp = new HashMap<>();
        hmp.put(Integer.MAX_VALUE, 0);

        while (check_idx != nums.length) {
            int cur = nums[check_idx];
            if (hmp.containsKey(cur)) {
                if (hmp.get(cur) < 2) {
                    hmp.replace(cur, hmp.get(cur) + 1);
                    nums[idx] = cur;
                    idx += 1;
                }
            } else {
                hmp.clear();
                hmp.put(cur, 1);
                nums[idx] = cur;
                idx += 1;
            }
            check_idx += 1;
        }
        return idx;
    }


    public static void main(String[] args) {
        LC080_Remove_Duplicates_From_Sorted_Array_II testCase = new LC080_Remove_Duplicates_From_Sorted_Array_II();

        int[] a0 = new int[]{};
        assert testCase.removeDuplicates(a0) == 0 : "Edge 0";

        int[] a1 = new int[]{1};
        assert testCase.removeDuplicates(a1) == 1 : "Edge 1";

        int[] a2 = new int[]{1, 1, 1, 2, 2, 3};
        assert testCase.removeDuplicates(a2) == 5 : "Example 1";
        assert Arrays.equals(a2, new int[]{1, 1, 2, 2, 3, 3}) : "Example 1 array check";

        int[] a3 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        assert testCase.removeDuplicates(a3) == 7 : "Example 2";
        assert Arrays.equals(a3, new int[]{0, 0, 1, 1, 2, 3, 3, 3, 3}) : "Example 2 array check";

        System.out.println("All passed");
    }
}

