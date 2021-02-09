import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * P102 Binary Tree Level Order Traversal
 * Medium
 * <p>
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
class LC102_Bianry_Tree_Level_Order_Traversal {
    /**
     * Version A
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList());

        if (root == null) {
            return result;
        }

        List<TreeNode> layer = new ArrayList<>(Arrays.asList(root));
        while (!layer.isEmpty()) {
            List<TreeNode> next_layer = new ArrayList<>(Arrays.asList());
            List<Integer> node_vals = new ArrayList<>(Arrays.asList());

            for (TreeNode node : layer) {
                node_vals.add(node.val);

                if (node.left != null) {
                    next_layer.add(node.left);
                }
                if (node.right != null) {
                    next_layer.add(node.right);
                }
            }

            layer = next_layer;
            result.add(node_vals);
        }
        return result;
    }


    public static void main(String[] args) {
        LC102_Bianry_Tree_Level_Order_Traversal testCase = new LC102_Bianry_Tree_Level_Order_Traversal();

        TreeNode T0 = null;
        assert testCase.levelOrder(T0).equals(new ArrayList<>(

        )) : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.levelOrder(T1).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ))) : "Example 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        });
        assert testCase.levelOrder(T2).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(9, 20)),
                new ArrayList<>(Arrays.asList(15, 7))
        ))) : "Example 2";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                0,
                2, 4,
                1, null, 3, -1,
                5, 1, null, null, 6, null, 8, null
        });
        assert testCase.levelOrder(T3).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(1, 3, -1)),
                new ArrayList<>(Arrays.asList(5, 1, 6, 8))
        ))) : "Additional 1";

        System.out.println("All passed");
    }
}

