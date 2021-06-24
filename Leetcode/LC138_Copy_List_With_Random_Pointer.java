import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * LC139 Copy List with Random Pointer
 * Medium
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Note:
 * You must return the copy of the given head as a reference to the cloned list.
 */


public class LC138_Copy_List_With_Random_Pointer {

    /**
     * 建立一个内部类作为测试使用
     */
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> check_list = new HashMap<>();

        /**
         * Inner class helper for memorization
         */
        class Helper {
            private Node help(Node head) {
                if (head != null) {
                    if (!check_list.containsKey(head)) {
                        Node new_head = new Node(head.val);
                        check_list.put(head, new_head);
                        new_head.next = this.help(head.next);
                        new_head.random = this.help(head.random);
                        return new_head;
                    } else {
                        return check_list.get(head);
                    }
                } else {
                    return head;
                }
            }
        }
        Helper h = new Helper();
        return h.help(head);
    }

    public static void main(String[] args) {
        Node B = new Node(2);
        B.next = null;
        B.random = B;
        Node A = new Node(1);
        A.next = B;
        A.random = B;

        LC138_Copy_List_With_Random_Pointer testCase = new LC138_Copy_List_With_Random_Pointer();
        Node AA = testCase.copyRandomList(A);

        assert AA.val == 1 : "Val";
        assert AA.next.val == 2 : "next Val";
        assert AA.random.val == 2 : "random val";
        assert AA.next.random.val == 2 : "cycling";
        assert AA.next.random == AA.next : "True self poiting";
        System.out.println("All passed");
    }


}

