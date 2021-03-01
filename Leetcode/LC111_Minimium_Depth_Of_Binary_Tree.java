/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * P111 Minimum Depth of Binary Tree
 * Easy
 * <p>
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class LC111_Minimium_Depth_Of_Binary_Tree {
    /**
     * Version STD
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) {
            return 1 + Math.min(this.minDepth(root.left), this.minDepth(root.right));
        } else {
            return 1 + Math.max(this.minDepth(root.left), this.minDepth(root.right));
        }
    }

    public static void main(String[] args) {
        LC111_Minimium_Depth_Of_Binary_Tree testCase = new LC111_Minimium_Depth_Of_Binary_Tree();

        TreeNode T0 = null;
        assert testCase.minDepth(T0) == 0 : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.minDepth(T1) == 1 : "Edge 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        });
        assert testCase.minDepth(T2) == 2 : "Example 1";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                2,
                null, 3,
                null, null, null, 4,
                null, null, null, null, null, null, null, 5,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6
        });
        assert testCase.minDepth(T3) == 5 : "Example 2";

        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                2, null
        });
        assert testCase.minDepth(T4) == 2 : "Additional 1";

        System.out.println("All passed");
    }
}
