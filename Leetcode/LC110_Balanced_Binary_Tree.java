import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * P110 Balanced Binary Tree
 * Easy
 * <p>
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
class LC110_Balanced_Binary_Tree {

    Map<TreeNode, Integer> MAX_DEPTH_HMP = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean ans = Math.abs(this.maxDepth(root.left) - this.maxDepth(root.right)) <= 1 &&
                this.isBalanced(root.left) && this.isBalanced(root.right);

        MAX_DEPTH_HMP.clear();

        return ans;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (MAX_DEPTH_HMP.containsKey(root)) {
            return MAX_DEPTH_HMP.get(root);
        } else {
            int max_depth = 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
            MAX_DEPTH_HMP.put(root, max_depth);
            return max_depth;
        }
    }


    public static void main(String[] args) {
        LC110_Balanced_Binary_Tree testCase = new LC110_Balanced_Binary_Tree();

        TreeNode T0 = null;
        assert testCase.isBalanced(T0) : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{1});
        assert testCase.isBalanced(T1) : "Edge 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        });
        assert testCase.isBalanced(T2) : "Example 1";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                3, 3, null, null,
                4, 4, null, null, null, null, null, null
        });
        assert !testCase.isBalanced(T3) : "Example 2";

        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                3, 3, 3, 3,
                4, 4, 4, 4, 4, 4, null, null,
                5, 5, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        });
        assert testCase.isBalanced(T4) : "Additional 1";


        TreeNode T5 = TreeNode.genTree(new Object[]{
                1,
                null, 2,
                null, null, null, 3,
        });
        assert !testCase.isBalanced(T5) : "Additional 2";

        TreeNode T6 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                3, 3, null, 3,
                4, 4, null, null, null, null, null, 4,
                5, 5, null, null, null, null, null, null, null, null, null, null, null, null, null, 5,
        });
        assert !testCase.isBalanced(T6) : "Additional 3";

        System.out.println("All passed");
    }
}

