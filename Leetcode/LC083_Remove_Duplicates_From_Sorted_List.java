/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * LC083 Remove Duplicates from Sorted List
 * Easy
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

public class LC083_Remove_Duplicates_From_Sorted_List {

    /**
     * Version B, move to a new_head
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumb = new ListNode(Integer.MAX_VALUE);
        ListNode new_head = dumb;
        while (head != null) {
            ListNode next_node = head.next;
            head.next = null;
            if (head.val != new_head.val) {
                new_head.next = head;
                new_head = new_head.next;
            }
            head = next_node;
        }

        return dumb.next;
    }

    public static void main(String[] args) {
        LC083_Remove_Duplicates_From_Sorted_List testCase = new LC083_Remove_Duplicates_From_Sorted_List();


        ListNode q1 = null;
        assert ListNode.showString(testCase.deleteDuplicates(q1)).equals("None") : "Edge 0";
        // 注意这里不能使用.equals因为null无法比较

        ListNode q2 = ListNode.genNode(new int[]{4});
        assert ListNode.showString(testCase.deleteDuplicates(q2)).equals("4") : "Single";

        ListNode q3 = ListNode.genNode(new int[]{1, 1, 2, 3, 3,});
        assert ListNode.showString(testCase.deleteDuplicates(q3)).equals("1->2->3");

        ListNode q4 = ListNode.genNode(new int[]{1, 1, 2});
        assert ListNode.showString(testCase.deleteDuplicates(q4)).equals("1->2") : "Example 2";

        System.out.println("All passed");
    }
}

