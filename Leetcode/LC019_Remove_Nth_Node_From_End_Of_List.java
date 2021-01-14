/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * P019 Remove Nth Node From End of List
 * Medium
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 */
class LC019_Remove_Nth_Node_From_End_Of_List {

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
        LC019_Remove_Nth_Node_From_End_Of_List testCase = new LC019_Remove_Nth_Node_From_End_Of_List();

        ListNode q1 = ListNode.genNode(new int[]{1});
        assert testCase.removeNthFromEnd(q1, 1) == null : "Edge 1";

        ListNode q2 = ListNode.genNode(new int[]{1, 2});
        ListNode a2 = ListNode.genNode(new int[]{2});
        assert testCase.removeNthFromEnd(q2, 2).equals(a2) : "Edge 2";


        ListNode q3 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode a3 = ListNode.genNode(new int[]{1, 2, 3, 5});
        assert testCase.removeNthFromEnd(q3, 2).equals(a3) : "Case 1";

        System.out.println("All passed");

    }


}

