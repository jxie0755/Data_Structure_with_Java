import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * LC094 Binary Tree Inorder Traversal
 * Medium
 * <p>
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 中序遍历就是二叉树的平面投影,从左到右
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
class LC094_Binary_Tree_Inorder_Traversal {
    /**
     * Version STD_A, using stack
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Object>> stack = new ArrayList<>();
        stack.add(new ArrayList<>(Arrays.asList(root, false)));

        while (!stack.isEmpty()) {
            List takeout = stack.remove(stack.size() - 1);
            root = (TreeNode) takeout.get(0);
            boolean is_visited = (boolean) takeout.get(1);
            if (root == null) {
                continue;
            }
            if (is_visited) {
                result.add(root.val);
            } else {
                stack.add(new ArrayList<>(Arrays.asList(root.right, false)));
                stack.add(new ArrayList<>(Arrays.asList(root, true)));
                stack.add(new ArrayList<>(Arrays.asList(root.left, false)));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        LC094_Binary_Tree_Inorder_Traversal testCase = new LC094_Binary_Tree_Inorder_Traversal();

        TreeNode t0 = null;
        assert testCase.inorderTraversal(t0).equals(
                new ArrayList<>()) : "Edge 0";

        TreeNode t = TreeNode.genTree(new Object[]{
                1,
                null, 2,
                null, null, 3, null
        });

        assert testCase.inorderTraversal(t).equals(
                new ArrayList<>(Arrays.asList(1, 3, 2))) : "Example 1";

        TreeNode t2 = TreeNode.genTree(new Object[]{
                6,
                2, 7,
                1, 4, null, 9,
                null, null, 3, 5, null, null, 8, null
        });
        assert testCase.inorderTraversal(t2).equals(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))) : "Additional 1";

        System.out.println("All passed");
    }
}

