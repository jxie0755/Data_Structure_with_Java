/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * P092 Reverse Linked List II
 * Medium
 * <p>
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
class LC092_Reverse_Linked_List_II {
    /**
     * Version A, one pass
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i += 1) {
            pre = pre.next;
        }

        ListNode end = pre.next;
        ListNode start = pre.next;
        ListNode tail = start.next;
        ListNode insert_point = null;

        for (int j = 0; j < n - m + 1; j += 1) {
            tail = start.next;

            start.next = insert_point;
            pre.next = start;
            insert_point = start;
            start = tail;
        }

        end.next = tail;
        return dummy.next;
    }

    public static void main(String[] args) {
        LC092_Reverse_Linked_List_II testCase = new LC092_Reverse_Linked_List_II();

        ListNode s1 = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.reverseBetween(s1, 1, 1)).equals("1") : "Edge 1";

        ListNode s2 = ListNode.genNode(new int[]{1, 2});
        assert ListNode.showString(testCase.reverseBetween(s2, 1, 2)).equals("2->1") : "Edge 2";

        ListNode s3 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert ListNode.showString(testCase.reverseBetween(s3, 2, 4)).equals("1->4->3->2->5") : "Example 1";

        System.out.println("All passed");
    }
}

