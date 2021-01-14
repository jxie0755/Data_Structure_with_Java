/**
 * https://leetcode.com/problems/rotate-list/
 * P061 Rotate List
 * Medium
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
class LC061_Roate_List {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        // Measure the length of the linked list, and locate the end node
        int length = 1;
        ListNode last_node = head;
        while (last_node.next != null) {
            last_node = last_node.next;
            length += 1;
        }

        // link the end to head to be a loop
        last_node.next = head;

        // locate the node before break point
        ListNode node_before_break = head;
        for (int i = 0; i < length - k % length - 1; i += 1) {
            node_before_break = node_before_break.next;
        }

        // locate the next node after break (as the new head), and break link in between
        ListNode new_head = node_before_break.next;
        node_before_break.next = null;
        return new_head;
    }


    public static void main(String[] args) {
        LC061_Roate_List testCase = new LC061_Roate_List();

        ListNode E0 = null;
        assert testCase.rotateRight(E0, 2) == null: "Edge 0";

        ListNode E1 = ListNode.genNode(new int[]{1});
        assert testCase.rotateRight(E1, 2).equals(E1) : "Edge 1";

        ListNode E2 = ListNode.genNode(new int[]{1, 2});
        assert testCase.rotateRight(E2, 1).equals(
                ListNode.genNode(new int[]{2, 1})
        ) : "Edge 2";

        ListNode S1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert testCase.rotateRight(S1, 2).equals(
                ListNode.genNode(new int[]{4, 5, 1, 2, 3})
        ) : "Example 1";

        ListNode S2 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert testCase.rotateRight(S2, 0).equals(
                ListNode.genNode(new int[]{1, 2, 3, 4, 5})
        ) : "Example 2";

        ListNode S3 = ListNode.genNode(new int[]{0, 1, 2});
        assert testCase.rotateRight(S3, 4).equals(
                ListNode.genNode(new int[]{2, 0, 1})
        ) : "Example 3";

        System.out.println("All passed");
    }
}

