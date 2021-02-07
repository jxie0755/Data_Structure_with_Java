/**
 * https://leetcode.com/problems/same-tree/
 * p100 Same Tree
 * Easy
 * <p>
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Note:
 * Mirrored trees are considered not the same
 * Circular trees can not be tested
 */
class LC100_Same_Tree {
    /**
     * Version A Recursive comparison
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val &&
                    this.isSameTree(p.left, q.left) &&
                    this.isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        LC100_Same_Tree testCase = new LC100_Same_Tree();

        TreeNode T0 = null;
        TreeNode T00 = null;
        TreeNode T000 = new TreeNode(5);

        assert testCase.isSameTree(T0, T00) : "Edge 0";
        assert !testCase.isSameTree(T0, T000) : "Edge 1";
        assert !testCase.isSameTree(T000, T00) : "Edge 2";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1,
                2, 3
        });

        TreeNode T2 = TreeNode.genTree(new Object[]{
                1,
                2, 3
        });
        assert testCase.isSameTree(T1, T2) : "Example 1";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                4, null, null, null
        });
        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                3, 2,
                4, null, null, null
        });
        assert !testCase.isSameTree(T3, T4) : "Example 2";

        TreeNode T5 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                null, 4, 5, null
        });
        TreeNode T6 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                null, 4, 5, null
        });
        assert testCase.isSameTree(T5, T6) : "Additional 1";

        System.out.println("All passed");

    }
}

