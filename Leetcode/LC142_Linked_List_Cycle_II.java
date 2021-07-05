import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * LC142 Linked List Cycle II
 * Medium
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 */
public class LC142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> ss = new HashSet<>(Arrays.asList());
        while (head != null) {
            if (ss.contains(head.next)) {
                return head.next;
            } else {
                ss.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LC142_Linked_List_Cycle_II testCase = new LC142_Linked_List_Cycle_II();

        ListNode L1 = ListNode.genNode(new int[]{3, 2, 0, 4});
        L1.next.next.next.next = L1.next;
        // 3 2 0 4
        // a b c d
        // d -> b
        assert testCase.detectCycle(L1) == L1.next : "Example 1";

        ListNode L2 = ListNode.genNode(new int[]{1, 2});
        L2.next.next = L2;
        // 1 2
        // a b
        // b -> a
        assert testCase.detectCycle(L2) == L2 : "Example 2";

        ListNode L3 = ListNode.genNode(new int[]{1});
        assert testCase.detectCycle(L3) == null : "Edge 1, no cycle";

        System.out.println("All passed");
    }
}

