/**
 * https://leetcode.com/problems/reorder-list/
 * LC143 Reorder List
 * Medium
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class LC143_Reorder_List {

    /**
     * Version STD
     */
    public void reorderList(ListNode head) {


        // find out half way linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second_half = slow.next;
        slow.next = null;

        // reverse second half (classic method)
        ListNode dummy = new ListNode(0);
        ListNode end = null;
        while (second_half != null) {
            ListNode temp = second_half.next;
            dummy.next = second_half;
            second_half.next = end;
            end = dummy.next;
            second_half = temp;
        }

        ListNode reversed_second_half = dummy.next;
        while (head != null && reversed_second_half != null) {
            ListNode head_next = head.next;
            ListNode second_next = reversed_second_half.next;

            head.next = reversed_second_half;
            reversed_second_half.next = head_next;

            head = head_next;
            reversed_second_half = second_next;
        }
    }

    public static void main(String[] args) {
        LC143_Reorder_List testCase = new LC143_Reorder_List();

        ListNode L1 = ListNode.genNode(new int[]{1});
        testCase.reorderList(L1);
        assert L1.equals(ListNode.genNode(new int[]{1})) : "Edege 1";

        ListNode L2 = ListNode.genNode(new int[]{1, 2, 3, 4});
        testCase.reorderList(L2);
        assert L2.equals(ListNode.genNode(new int[]{1, 4, 2, 3})) : "Example 1";

        ListNode L3 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        testCase.reorderList(L3);
        assert L3.equals(ListNode.genNode(new int[]{1, 5, 2, 4, 3})) : "Example 2";
        System.out.println("All passed");
    }

}

