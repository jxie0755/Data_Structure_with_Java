/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * P023 Merge k Sorted Lists
 * Hard
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
class LC023_Merge_K_Sorted_List {

    /**
     * Version C2
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        int left = 0;
        int right = lists.length - 1;

        while (right > 0) {
            if (left >= right) {
                left = 0;
            } else {
                lists[left] = this.merge_two(lists[left], lists[right]);
                left += 1;
                right -= 1;
            }
        }
        return lists[0];
    }

    // Helper - version C2
    // Merge two sorted linked list to a sorted linked list
    private ListNode merge_two(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LC023_Merge_K_Sorted_List testCase = new LC023_Merge_K_Sorted_List();

        assert ListNode.showString(testCase.mergeKLists(new ListNode[]{})).equals("None") : "Edge 0";

        ListNode single = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.mergeKLists(new ListNode[]{single})).equals("1") : "Single";

        ListNode a = ListNode.genNode(new int[]{1, 4, 5});
        ListNode b = ListNode.genNode(new int[]{1, 3, 4});
        ListNode c = ListNode.genNode(new int[]{2, 6});
        assert ListNode.showString(testCase.mergeKLists(new ListNode[]{a, b, c})).equals("1->1->2->3->4->4->5->6") : "Example";

        System.out.println("All passed");
    }
}

