/**
 * P002 Add Two Numbers
 * Medium
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class LC002_Add_Two_Numbers {

    /**
     * Version A, Time:  O(n), Space: O(1)
     * Non-recursion  method
     * This will protect l1 and l2 from changing
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            carry = val / 10;
            val = val % 10;

            current.next = new ListNode(val);
            current = current.next;
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }

        return dummy.next;
    }


    public static void main(String[] args) {

        ListNode a1 = ListNode.genNode(new int[]{0});
        ListNode b1 = ListNode.genNode(new int[]{0, 1});
        ListNode c1 = new LC002_Add_Two_Numbers().addTwoNumbers(a1, b1);
        assert ListNode.showString(c1).equals("0->1") : "Simple Case 1";

        ListNode a2 = new ListNode(9);
        ListNode b2 = new ListNode(9);
        ListNode c2 = new LC002_Add_Two_Numbers().addTwoNumbers(a2, b2);
        assert ListNode.showString(c2).equals("8->1") : "Simple Case 2";

        ListNode a3 = ListNode.genNode(new int[]{2, 4, 3});
        ListNode b3 = ListNode.genNode(new int[]{5, 6, 4});
        ListNode c3 = new LC002_Add_Two_Numbers().addTwoNumbers(a3, b3);
        assert ListNode.showString(c3).equals("7->0->8") : "Example 1";

        ListNode a4 = ListNode.genNode(new int[]{2, 4, 3});
        ListNode b4 = ListNode.genNode(new int[]{8, 9});
        ListNode c4 = new LC002_Add_Two_Numbers().addTwoNumbers(a4, b4);
        assert ListNode.showString(c4).equals("0->4->4") : "Example 2";

        System.out.println("all passed");
    }
}

