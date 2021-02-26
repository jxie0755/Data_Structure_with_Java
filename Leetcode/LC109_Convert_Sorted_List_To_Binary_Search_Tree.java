import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * P109 Convert Sorted List to Binary Search Tree
 * Medium
 * <p>
 * <p>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
class LC109_Convert_Sorted_List_To_Binary_Search_Tree {
    /**
     * Version A
     * Use helper from LC108, but with List<Integer> structure
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> numsList = new ArrayList<>(Arrays.asList());
        while (head != null) {
            numsList.add(head.val);
            head = head.next;
        }

        return this.sortedArrayToBST_Helper(numsList);
    }

    /**
     * Helper from LC108
     * Modified into List<Integer>
     */
    private TreeNode sortedArrayToBST_Helper(List<Integer> numsList) {
        if (numsList.size() == 0) {
            return null;
        }

        int mid_idx = numsList.size() / 2;
        int mid_val = numsList.get(mid_idx);
        TreeNode T = new TreeNode(mid_val);

        T.left = this.sortedArrayToBST_Helper(numsList.subList(0, mid_idx));
        T.right = this.sortedArrayToBST_Helper(numsList.subList(mid_idx + 1, numsList.size()));

        return T;
    }


    public static void main(String[] args) {
        LC109_Convert_Sorted_List_To_Binary_Search_Tree testCase = new LC109_Convert_Sorted_List_To_Binary_Search_Tree();

        ListNode A0 = ListNode.genNode(new int[]{});
        assert testCase.sortedListToBST(A0) == null : "Edge 0";

        ListNode A1 = ListNode.genNode(new int[]{1});
        assert testCase.sortedListToBST(A1).equals(TreeNode.genTree(new Object[]{
                1
        })) : "Edge 1";

        ListNode A2 = ListNode.genNode(new int[]{-10, -3, 0, 5, 9});
        assert testCase.sortedListToBST(A2).equals(TreeNode.genTree(new Object[]{
                0,
                -3, 9,
                -10, null, 5, null
        })) : "Example 1";

        System.out.println("All passed");
    }
}

