

/**
 * https://leetcode.com/problems/partition-list/
 * P086 Partition List
 * Medium
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class LC086_Partition_List {

    /**
     * Version B, move in-place
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return head;
        }

        ListNode dumb = new ListNode(0);
        ListNode pre = dumb;
        pre.next = head;

        boolean found = false;
        while (pre != null && pre.next != null) {
            if (pre.next.val >= x) {
                found = true;
                break;
            } else {
                pre = pre.next;
            }
        }

        if (!found) {
            return head;
        }

        ListNode partition_head = pre.next;
        ListNode partition_tail = pre.next;
        ListNode check = partition_tail.next;
        while (check != null) {
            if (check.val < x) {
                ListNode this_node = check;
                check = check.next;

                pre.next = this_node;
                this_node.next = partition_head;

                partition_tail.next = check;
                pre = pre.next;
            } else {
                partition_tail = partition_tail.next;
                check = check.next;
            }
        }

        return dumb.next;
    }

    public static void main(String[] args) {
        LC086_Partition_List testCase = new LC086_Partition_List();

        ListNode q1 = ListNode.genNode(new int[]{});
        assert ListNode.showString(testCase.partition(q1, 5)).equals("None") : "Edge 0";

        ListNode q2 = ListNode.genNode(new int[]{9, 1, 4, 3, 2, 5, 2});
        assert ListNode.showString(testCase.partition(q2, 9)).equals("1->4->3->2->5->2->9") : "Edge 1";

        ListNode q3 = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.partition(q3, 2)).equals("1") : "Edge 2";

        ListNode q4 = ListNode.genNode(new int[]{1, 4, 3, 2, 5, 2});
        assert ListNode.showString(testCase.partition(q4, 3)).equals("1->2->2->4->3->5") : "Example 1";

        System.out.println("All passed");
    }
}

