/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * LC104 Maximum Depth of Binary Tree
 * Easy
 * <p>
 * <p>
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
class LC104_Maximum_Depth_Of_Binary_Tree {
    /**
     * Version A
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
        }
    }


    public static void main(String[] args) {
        LC104_Maximum_Depth_Of_Binary_Tree testCase = new LC104_Maximum_Depth_Of_Binary_Tree();

        TreeNode T0 = null;
        assert testCase.maxDepth(T0) == 0 : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.maxDepth(T1) == 1 : "Edge 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                1,
                9, 20,
                null, null, 15, null
        });
        assert testCase.maxDepth(T2) == 3 : "Edge 0";

        System.out.println("All passed");
    }
}

