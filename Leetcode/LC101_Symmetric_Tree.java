import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https: // leetcode.com / problems / symmetric - tree /
 * LC101 Symmetric Tree
 * Easy
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center)
 */
class LC101_Symmetric_Tree {
    /**
     * Version STD1, using stack
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> stack = new ArrayList<>(Arrays.asList(root.left, root.right));

        while (!stack.isEmpty()) {
            TreeNode L = stack.remove(stack.size() - 1);
            TreeNode R = stack.remove(stack.size() - 1);

            if (L == null && R == null) {
                continue;
            } else if (L == null || R == null || L.val != R.val) {
                return false;
            }

            stack.add(L.left);
            stack.add(R.right);

            stack.add(L.right);
            stack.add(R.left);
        }

        return true;
    }

    public static void main(String[] args) {
        LC101_Symmetric_Tree testCase = new LC101_Symmetric_Tree();

        TreeNode T0 = null;
        assert testCase.isSymmetric(T0) : "Edge 0";

        TreeNode T00 = new TreeNode(1);
        assert testCase.isSymmetric(T00) : "Edge 1";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                3, 4, 4, 3
        });
        assert testCase.isSymmetric(T1) : "Example 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                null, 3, null, 3
        });
        assert !testCase.isSymmetric(T2) : "Example 2";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                1,
                0, null
        });
        assert !testCase.isSymmetric(T3) : "Additional 1";

        TreeNode T4 = TreeNode.genTree(new Object[]{
                1,
                2, 2,
                null, 3, 3, null,
                null, null, 4, null, null, 4, null, null
        });
        assert testCase.isSymmetric(T4) : "Example Additional 2";

        System.out.println("All passed");
    }
}

