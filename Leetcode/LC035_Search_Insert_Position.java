import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-insert-position/
 * p035 Search Insert Position
 * Easy
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array
 */
class LC035_Search_Insert_Position {

    /**
     * # Version A, sort first
     */
    public int searchInsert(int[] nums, int target) {

        int[] new_nums = Arrays.copyOf(nums, nums.length + 1);
        new_nums[new_nums.length - 1] = target;
        Arrays.sort(new_nums);

        int index = 0;
        while (index < new_nums.length) {
            if (new_nums[index] == target) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC035_Search_Insert_Position testCase = new LC035_Search_Insert_Position();

        int[] E = new int[]{0};
        assert testCase.searchInsert(E, 1) == 0 : "Empty";

        int[] Q = new int[]{1, 3, 5, 6};
        assert testCase.searchInsert(Q, 5) == 2 : "In the list";
        assert testCase.searchInsert(Q, 2) == 1 : "Not in the list";
        assert testCase.searchInsert(Q, 7) == 4 : "At the end";
        assert testCase.searchInsert(Q, 0) == 0 : "At the beginning";
        System.out.println("all passed");
    }

}

