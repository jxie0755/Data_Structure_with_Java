/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * p083 Remove Duplicates from Sorted List
 * Easy
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

public class LC083_Remove_Duplicates_From_Sorted_List {

    /**
     * Version A, move in place
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode cur = head;
            ListNode tail = head.next;
            while (tail != null) {
                if (cur.val != tail.val) {
                    cur.next = tail;
                    cur = cur.next;
                } else {
                    cur.next = null;
                }
                tail = tail.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        LC083_Remove_Duplicates_From_Sorted_List testCase = new LC083_Remove_Duplicates_From_Sorted_List();


        ListNode q1 = ListNode.genNode(new int[]{});
        ListNode a1 = ListNode.genNode(new int[]{});
        assert testCase.deleteDuplicates(q1) == null : "Empty";
        // 注意这里不能使用.equals因为null无法比较

        ListNode q2 = ListNode.genNode(new int[]{4});
        ListNode a2 = ListNode.genNode(new int[]{4});
        assert testCase.deleteDuplicates(q2).equals(a2) : "Single";

        ListNode q3 = ListNode.genNode(new int[]{1, 1, 2, 3, 3,});
        ListNode a3 = ListNode.genNode(new int[]{1, 2, 3});
        assert testCase.deleteDuplicates(q3).equals(a3) : "Example 1";

        ListNode q4 = ListNode.genNode(new int[]{1, 1, 2});
        ListNode a4 = ListNode.genNode(new int[]{1, 2});
        assert testCase.deleteDuplicates(q4).equals(a4) : "Example 2";

        System.out.println("all passed");
    }
}

