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

    public static String showString(ListNode A) {
        if (A.next != null) {
            return A.val + "->" + showString(A.next);
        } else {
            return String.valueOf(A.val);
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
        assert ListNode.showString(A).equals("1->2->3");

        // Test equal
        assert A.equals(D);

        // Test genNode
        ListNode X = ListNode.genNode(new int[]{10, 20, 30});
        System.out.println(ListNode.showString(X));
        // >>> 10->20->30

        System.out.println(X.hashCode());
        // >>> 1531333864
        System.out.println(Integer.toHexString(X.hashCode()));
        // >>> 5b464ce8   --------------------------------------------this is how we got this in Map
        // reference: https://stackoverflow.com/q/56763937/8435726

        // Test hashable
        Map<ListNode, Integer> hmp = new HashMap<>(Map.ofEntries(
                Map.entry(ListNode.genNode(new int[]{10, 20, 30}), 0),
                Map.entry(ListNode.genNode(new int[]{40, 50, 60}), 1),
                Map.entry(ListNode.genNode(new int[]{70, 80, 90}), 2),
                Map.entry(X, 3)
                ));

        System.out.println(hmp);
        // >>> {ListNode@4e04a765=3, ListNode@735f7ae5=2, ListNode@17550481=1, ListNode@783e6358=0}
        //                   |
        //                   ---------------------------------------------------same as above

    }
}

