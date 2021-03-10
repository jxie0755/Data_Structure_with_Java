/**
 * https://leetcode.com/problems/path-sum/
 * LC112 Path Sum
 * Easy
 * <p>
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 */
class LC112_Path_Sum {
    /**
     * Version A2
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.pathSumChecker(root, 0, targetSum);
    }

    private boolean pathSumChecker(TreeNode root, int carryover, int targetSum) {
        if (root == null) {
            return false;
        } else {
            int new_carryover = carryover + root.val;
            if (root.left == null && root.right == null) { // isLeaf
                return new_carryover == targetSum;
            } else {
                return this.pathSumChecker(root.left, new_carryover, targetSum) ||
                        this.pathSumChecker(root.right, new_carryover, targetSum);
            }
        }

    }

    public static void main(String[] args) {
        LC112_Path_Sum testCase = new LC112_Path_Sum();

        TreeNode T0 = null;
        assert !testCase.hasPathSum(T0, 0) : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.hasPathSum(T1, 1) : "Edge 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1
        });
        assert testCase.hasPathSum(T2, 22) : "Example 1";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                1,
                2, 3
        });
        assert !testCase.hasPathSum(T3, 5) : "Example 2";

        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                2, null
        });
        assert !testCase.hasPathSum(T4, 22) : "Example 3";

        System.out.println("All passed");
    }
}

