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
        ListNode find_end = head;
        while (find_end.next != null) {
            find_end = find_end.next;
            length += 1;
        }

        // Special cases
        if (k % length == 0) {
            return head;
        } else if (k > length) {
            return this.rotateRight(head, k % length);
        }

        // Common cases

        // locate the node before break point
        ListNode find_node_before_break = head;
        for (int i = 0; i < length - k - 1; i += 1) {
            find_node_before_break = find_node_before_break.next;
        }

        // link the end to head to be a loop
        find_end.next = head;

        // locate the next node (as the new head), and break link of the two node
        ListNode new_head = find_node_before_break.next;
        find_node_before_break.next = null;
        return new_head;
    }

    public static void main(String[] args) {

        ListNode E0 = ListNode.genNode(new int[]{});
        ListNode E0A = ListNode.genNode(new int[]{});
        assert new LC061_Roate_List().rotateRight(E0, 2) == E0A : "Edge 0";

        ListNode E1 = ListNode.genNode(new int[]{1});
        assert new LC061_Roate_List().rotateRight(E1, 2).equals(E1) : "Edge 1";

        ListNode E2 = ListNode.genNode(new int[]{1, 2});
        assert new LC061_Roate_List().rotateRight(E2, 1).equals(ListNode.genNode(new int[]{2, 1})) : "Edge 2";

        ListNode S1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert new LC061_Roate_List().rotateRight(S1, 2).equals(ListNode.genNode(new int[]{4, 5, 1, 2, 3})) : "Example 2";
        ListNode S2 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert new LC061_Roate_List().rotateRight(S2, 0).equals(ListNode.genNode(new int[]{1, 2, 3, 4, 5})) : "Example 2";
        ListNode S3 = ListNode.genNode(new int[]{0, 1, 2});
        assert new LC061_Roate_List().rotateRight(S3, 4).equals(ListNode.genNode(new int[]{2, 0, 1})) : "Example 3";

        System.out.println("all passed");
    }
}

