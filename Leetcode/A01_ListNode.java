import java.util.HashMap;
import java.util.Map;

public class A01_ListNode {

}


/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        if (this.next != null) {
            return this.val + "->" + this.next.toString();
        } else {
            return String.valueOf(this.val);
        }
    }

    public boolean equals(ListNode other) {
        if (this.next == null && other.next == null) {
            return this.val == other.val;
        } else if (this.next == null || other.next == null) {
            return false;
        } else {
            return this.val == other.val && this.next.equals(other.next);
        }
    }

    public static ListNode genNode(int[] nodelist) {
        // must be a none-empty array
        ListNode head = new ListNode(nodelist[0]);
        ListNode cur = head;
        for (int i = 1; i != nodelist.length; i += 1) {
            ListNode n = new ListNode(nodelist[i]);
            cur.next = n;
            cur = n;
        }

        return head;
    }


    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        A.next = B;
        B.next = C;
        ListNode D = new ListNode(1);
        ListNode E = new ListNode(2);
        ListNode F = new ListNode(3);
        D.next = E;
        E.next = F;


        // Test print
        assert A.toString().equals("1->2->3");

        // Test equal
        assert A.equals(D);

        // Test hashable
        Map<ListNode, Integer> hmp = new HashMap<>(Map.ofEntries(
                Map.entry(A, 0),
                Map.entry(B, 1),
                Map.entry(C, 2)
                ));

        System.out.println(hmp);
        // >>> {3=2, 2->3=1, 1->2->3=0}
    }
}

