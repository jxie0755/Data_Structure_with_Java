/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * P82 Remove Duplicates from Sorted List II
 * Medium
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */
public class LC082_Remove_Duplicates_From_Sorted_List_II {

    /**
     * Version B
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;
        dummy.next = head;
        ListNode tail = head.next;
        boolean repeat = false;

        while (tail != null) {
            if (head.val != tail.val) {
                if (!repeat) {
                    cur.next = head;
                    cur = cur.next;
                } else {
                    if (tail.next != null) {
                        repeat = false;
                    } else {
                        cur.next = tail;
                    }
                }
            } else {
                cur.next = null;
                repeat = true;
            }
            head = head.next;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LC082_Remove_Duplicates_From_Sorted_List_II testCase = new LC082_Remove_Duplicates_From_Sorted_List_II();

        ListNode q1 = ListNode.genNode(new int[]{});
        assert ListNode.showString(testCase.deleteDuplicates(q1)).equals("None") : "Edge 1";

        ListNode q2 = ListNode.genNode(new int[]{1, 1});
        assert ListNode.showString(testCase.deleteDuplicates(q2)).equals("None") : "Edge 2";

        ListNode q3 = ListNode.genNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        assert ListNode.showString(testCase.deleteDuplicates(q3)).equals("1->2->5") : "Example 1";

        ListNode q4 = ListNode.genNode(new int[]{1, 1, 1, 2, 3});
        assert ListNode.showString(testCase.deleteDuplicates(q4)).equals("2->3") : "Example 2";

        System.out.println("all passed");
    }
}

