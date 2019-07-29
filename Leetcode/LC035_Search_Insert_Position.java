/**
 * https://leetcode.com/problems/search-insert-position/
 * p035 Search Insert Position
 * Easy
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array
 */
public class LC035_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

    }

    public static void main(String[] args) {

        int[] E = new int[]{};
        assert new LC035_Search_Insert_Position().searchInsert(E, 1) == 0 : "Empty";

        int[] Q = new int[]{1, 3, 5, 6};
        assert new LC035_Search_Insert_Position().searchInsert(Q, 5) == 2 : "In the list";
        assert new LC035_Search_Insert_Position().searchInsert(Q, 2) == 1 : "Not in the list";
        assert new LC035_Search_Insert_Position().searchInsert(Q, 2) == 7 : "At the end";
        assert new LC035_Search_Insert_Position().searchInsert(Q, 0) == 0 : "At the beginning";
        System.out.println("all passed");
    }

}

