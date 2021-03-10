import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * LC114 Flatten Binary Tree to Linked List
 * Medium
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * Notes:
 * - The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * - The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
class LC114_Flatten_Binary_Tree_To_Linked_List {

    /**
     * Version A
     */
    public void flatten(TreeNode root) {
        TreeNode dumb = new TreeNode(0);

        for (TreeNode node : this.preOrderTraversalNodes(root)) {
            dumb.right = node;
            dumb = dumb.right;
            dumb.left = null;
        }
    }

    private List<TreeNode> preOrderTraversalNodes(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> ans = new ArrayList<>(Arrays.asList());
        ans.add(root);
        ans.addAll(this.preOrderTraversalNodes(root.left));
        ans.addAll(this.preOrderTraversalNodes(root.right));
        return ans;
    }

    public static void main(String[] args) {
        LC114_Flatten_Binary_Tree_To_Linked_List testCase = new LC114_Flatten_Binary_Tree_To_Linked_List();

        TreeNode T0 = null;
        testCase.flatten(T0);
        TreeNode A0 = null;
        assert T0 == null : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                0
        });
        testCase.flatten(T1);
        TreeNode A1 = TreeNode.genTree(new Object[]{
                0
        });
        assert T1.equals(A1) : "Edge 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                1
        });
        testCase.flatten(T2);
        TreeNode A2 = TreeNode.genTree(new Object[]{
                1
        });
        assert T2.equals(A2) : "Edge 11";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                1,
                2, 5,
                3, 4, null, 6
        });
        testCase.flatten(T3);
        TreeNode A3 = TreeNode.genTree(new Object[]{
                1,
                null, 2,
                null, null, null, 3,
                null, null, null, null, null, null, null, 4,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 5,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6
        });
        assert T3.equals(A3) : "Example 1";

        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
        });
        testCase.flatten(T4);
        TreeNode A4 = TreeNode.genTree(new Object[]{
                1,
                null, 2,
                null, null, null, 3,
        });
        assert T4.equals(A4) : "Additional 1";

        System.out.println("All passed");
    }
}

