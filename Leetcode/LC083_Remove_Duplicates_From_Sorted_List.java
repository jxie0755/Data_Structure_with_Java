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


        ListNode q1 = ListNode.genNode(new int[]{0});
        assert ListNode.showString(testCase.deleteDuplicates(q1)).equals("None") : "Empty";
        // 注意这里不能使用.equals因为null无法比较

        ListNode q2 = ListNode.genNode(new int[]{4});
        assert ListNode.showString(testCase.deleteDuplicates(q2)).equals("4") : "Single";

        ListNode q3 = ListNode.genNode(new int[]{1, 1, 2, 3, 3,});
        assert ListNode.showString(testCase.deleteDuplicates(q3)).equals("1->2->3");

        ListNode q4 = ListNode.genNode(new int[]{1, 1, 2});
        assert ListNode.showString(testCase.deleteDuplicates(q4)).equals("1->2") : "Example 2";

        System.out.println("All passed");
    }
}

