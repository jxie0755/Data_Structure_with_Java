/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * P025 Reverse Nodes in k-group
 * Hard
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
class LC025_Reverse_Nodes_In_K_Group {

    private ListNode reverseNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode rest = head.next;
            ListNode tail = dummy.next;
            head.next = tail;
            dummy.next = head;
            head = rest;
        }

        return dummy.next;
    }


    /**
     * Version A
     * Recursive method
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1 || head == null) {
            return head;
        }

        ListNode cur = head;

        // 就走一次k节
        for (int i = 0; i < k - 1; i += 1) {
            if (cur.next != null) {
                cur = cur.next;
            } else {
                return head;
            }
        }

        // 断开,但是不能忘记下一个节点,以备用
        ListNode next_cur = cur.next;
        cur.next = null;

        // reverse前k个节点, 此时k-group的最后一个节点变成了反转后的头
        ListNode new_cur = this.reverseNodes(head);

        // 反转后,cur也就是tail了
        head.next = this.reverseKGroup(next_cur, k);
        return new_cur;
    }

    public static void main(String[] args) {
        LC025_Reverse_Nodes_In_K_Group testCase = new LC025_Reverse_Nodes_In_K_Group();

        // test reverseNodes
        ListNode x = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert ListNode.showString(testCase.reverseNodes(x)).equals("5->4->3->2->1");

        ListNode Q0 = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.reverseKGroup(Q0, 2)).equals("1") : "Single";

        ListNode E1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert ListNode.showString(testCase.reverseKGroup(E1, 1)).equals("1->2->3->4->5") : "k=1";

        ListNode E2 = ListNode.genNode(new int[]{1, 2});
        assert ListNode.showString(testCase.reverseKGroup(E2, 2)).equals("2->1") : "k=length";


        ListNode Q1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert ListNode.showString(testCase.reverseKGroup(Q1, 2)).equals("2->1->4->3->5") : "Example 1";

        ListNode Q2 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode A2 = ListNode.genNode(new int[]{3, 2, 1, 4, 5});
        assert ListNode.showString(testCase.reverseKGroup(Q2, 3)).equals("3->2->1->4->5") : "Example 2";

        System.out.println("all passed");
    }
}

