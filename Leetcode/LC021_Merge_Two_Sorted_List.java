/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * p021 Merge two sorted list
 * Easy
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
class LC021_Merge_Two_Sorted_List {

    /**
     * Version A
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        LC021_Merge_Two_Sorted_List testCase = new LC021_Merge_Two_Sorted_List();

        ListNode l1 = ListNode.genNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.genNode(new int[]{1, 3, 4});
        ListNode l3 = ListNode.genNode(new int[]{1, 1, 2, 3, 4, 4});
        assert testCase.mergeTwoLists(l1, l2).equals(l3) : "Example 1";

        System.out.println("all passed");
    }
}

