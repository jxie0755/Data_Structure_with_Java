

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * P024 Swap Nodes in Pairs
 * Medium
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
class LC024_Swap_Nodes_In_Pairs {

    /**
     * Version A, 用List重排
     */
    // public ListNode swapPairs(ListNode head) {
    //
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //
    //     // create a list of Nodes
    //     List<ListNode> node_list = new ArrayList<>();
    //     ListNode cur = head;
    //     while (cur != null) {
    //         node_list.add(cur);
    //         cur = cur.next;
    //     }
    //
    //     // swap in list
    //     for (int i = 0; i < node_list.size(); i += 2) {
    //         if (node_list.get(i).next != null) {
    //             ListNode temp = node_list.get(i);
    //             node_list.set(i, node_list.get(i + 1));
    //             node_list.set(i + 1, temp);
    //         }
    //     }
    //
    //     // re-link
    //     int i = 0;
    //     while (i != node_list.size() - 1) {
    //         node_list.get(i).next = node_list.get(i + 1);
    //         i += 1;
    //     }
    //     node_list.get(i).next = null;
    //
    //     return node_list.get(0);
    // }


    /**
     * Version B1
     * 递归法交换
     */
    public ListNode swapPairs(ListNode head) {

        if (head != null && head.next != null) {
            ListNode new_head = head.next;
            ListNode next_pair_first = head.next.next;

            new_head.next = head;
            head.next = this.swapPairs(next_pair_first);

            return new_head;
        } else {
            return head;
        }

    }

    public static void main(String[] args) {
        LC024_Swap_Nodes_In_Pairs testCase = new LC024_Swap_Nodes_In_Pairs();

        assert testCase.swapPairs(null) == null : "Empty";

        ListNode Q1 = ListNode.genNode(new int[]{1});
        assert ListNode.showString(testCase.swapPairs(Q1)).equals("1") : "Single";

        ListNode Q2 = ListNode.genNode(new int[]{1, 2});
        assert ListNode.showString(testCase.swapPairs(Q2)).equals("2->1") : "1 Pair";

        ListNode Q3 = ListNode.genNode(new int[]{1, 2, 3, 4});
        assert ListNode.showString(testCase.swapPairs(Q3)).equals("2->1->4->3") : "Even Length";

        ListNode Q4 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        assert ListNode.showString(testCase.swapPairs(Q4)).equals("2->1->4->3->5") : "Odd Length";

        System.out.println("All passed");
    }
}

