/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * LC082 Remove Duplicates from Sorted List II
 * Medium
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */
public class LC082_Remove_Duplicates_From_Sorted_List_II {

    /**
     * Version C
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next == null) {
            if (head.val == head.next.val) {
                return null;
            } else {
                return head;
            }
        } else {
            if (head.val != head.next.val && head.next.val != head.next.next.val) {
                head.next.next = this.deleteDuplicates(head.next.next);
                return head;
            } else if (head.val != head.next.val && head.next.val == head.next.next.val) {
                head.next = this.deleteDuplicates(head.next);
                return head;
            } else if (head.val == head.next.val && head.next.val != head.next.next.val) {
                return this.deleteDuplicates(head.next.next);
            } else  { // head.val == head.next.val && head.next.val == head.next.next.val
                return this.deleteDuplicates(head.next);
            }
        }
    }

    public static void main(String[] args) {
        LC082_Remove_Duplicates_From_Sorted_List_II testCase = new LC082_Remove_Duplicates_From_Sorted_List_II();

        ListNode q1 = ListNode.genNode(new int[]{});
        assert ListNode.showString(testCase.deleteDuplicates(q1)).equals("None") : "Edge 0";

        ListNode q2 = ListNode.genNode(new int[]{1, 1});
        assert ListNode.showString(testCase.deleteDuplicates(q2)).equals("None") : "Edge 1";

        ListNode q3 = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.deleteDuplicates(q3)).equals("1") : "Edge 2";


        ListNode q4 = ListNode.genNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        assert ListNode.showString(testCase.deleteDuplicates(q4)).equals("1->2->5") : "Example 1";

        ListNode q5 = ListNode.genNode(new int[]{1, 1, 1, 2, 3});
        assert ListNode.showString(testCase.deleteDuplicates(q5)).equals("2->3") : "Example 2";

        ListNode q6 = ListNode.genNode(new int[]{1, 2, 2});
        assert ListNode.showString(testCase.deleteDuplicates(q6)).equals("1") : "Additional 1";

        ListNode q7 = ListNode.genNode(new int[]{1, 2, 2, 3});
        assert ListNode.showString(testCase.deleteDuplicates(q7)).equals("1->3") : "Additional 2";

        ListNode q8 = ListNode.genNode(new int[]{1, 2, 2, 2});
        assert ListNode.showString(testCase.deleteDuplicates(q8)).equals("1") : "Additional 3";

        ListNode q9 = ListNode.genNode(new int[]{1, 1, 1, 1});
        assert ListNode.showString(testCase.deleteDuplicates(q9)).equals("None") : "Additional 3";

        System.out.println("All passed");
    }
}

