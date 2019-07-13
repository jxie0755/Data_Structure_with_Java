/**
 * P019 Remove Nth Node From End of List
 * Medium
 *
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 */
public class LC019_Remove_Nth_Node_From_End_Of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i += 1) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {

        ListNode q1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode a1 = ListNode.genNode(new int[]{1, 2, 3, 5});
        assert new LC019_Remove_Nth_Node_From_End_Of_List().removeNthFromEnd(q1, 2).equals(a1);

        ListNode q2 = ListNode.genNode(new int[]{1});
        assert new LC019_Remove_Nth_Node_From_End_Of_List().removeNthFromEnd(q2, 1) == null;

        System.out.println("all passed");

    }


}

