/**
 * P025 Reverse Nodes in k-group
 * Hard
 *
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class LC025_Reverse_Nodes_In_K_Group {

    public ListNode reverseKGroup(ListNode head, int k) {

    }

    public static void main(String[] args) {

        ListNode Q1 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode A1 = ListNode.genNode(new int[]{2, 1, 4, 3, 5});
        assert new LC025_Reverse_Nodes_In_K_Group().reverseKGroup(Q1, 2).equals(A1): "Example 1";

        ListNode Q2 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode A2 = ListNode.genNode(new int[]{3, 2, 1, 4, 5});
        assert new LC025_Reverse_Nodes_In_K_Group().reverseKGroup(Q2, 3).equals(A2): "Example 2";

        System.out.println("all passed");

    }

}

