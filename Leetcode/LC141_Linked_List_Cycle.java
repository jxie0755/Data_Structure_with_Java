/**
 * https://leetcode.com/problems/linked-list-cycle/
 * LC141 Linked List Cycle
 * Easy
 *
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 */
public class LC141_Linked_List_Cycle {

    /**
     * Version D, slow and fast node method
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC141_Linked_List_Cycle testCase = new LC141_Linked_List_Cycle();

        ListNode L1 = ListNode.genNode(new int[]{3, 2, 0, -4});
        L1.next.next.next.next = L1.next;
        // 3 2 0 - 4
        // a b c d
        // d -> b cycle
        assert testCase.hasCycle(L1) : "Example 1";

        ListNode L2 = ListNode.genNode(new int[]{1, 2});
        L2.next.next = L2;
        // 1 2
        // a b
        // b -> a cycle
        assert testCase.hasCycle(L2) : "Example 2";

        ListNode L3 = ListNode.genNode(new int[]{1});
        assert !testCase.hasCycle(L3) : "Example 3";

        ListNode L4 = ListNode.genNode(new int[]{1, 1, 1, 1});
        L4.next.next.next.next = L4.next;
        // 1 1 1 1
        // a b c d
        // d -> b cycle
        assert testCase.hasCycle(L1) : "Additional 1 same value nodes";

        ListNode L5 = ListNode.genNode(new int[]{1, 1, 1, 1});
        assert !testCase.hasCycle(L5) : "Additional 2 same value nodes";

        System.out.println("All passed");
    }
}

