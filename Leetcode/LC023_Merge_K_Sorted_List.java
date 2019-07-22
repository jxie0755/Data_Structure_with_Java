/**
 * P023 Merge k Sorted Lists
 * Hard
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class LC023_Merge_K_Sorted_List {

    /**
     * Merge two sorted linked list to a sorted linked list
     */
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

    public static void main(String[] args) {

        assert new LC023_Merge_K_Sorted_List().mergeKLists(new ListNode[]{}) == null : "Empty";

        ListNode single = ListNode.genNode(new int[]{1});
        assert new LC023_Merge_K_Sorted_List().mergeKLists(new ListNode[]{single}).equals(single) : "Single";

        ListNode a = ListNode.genNode(new int[]{1, 4, 5});
        ListNode b = ListNode.genNode(new int[]{1, 3, 4});
        ListNode c = ListNode.genNode(new int[]{2, 6});
        ListNode ans = ListNode.genNode(new int[]{1, 1, 2, 3, 4, 4, 5, 6});

        assert new LC023_Merge_K_Sorted_List().mergeKLists(new ListNode[]{a, b, c}).equals(ans) : "Example";

        System.out.println("all passed");


    }

}

