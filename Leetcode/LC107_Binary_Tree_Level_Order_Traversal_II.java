import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * LC107 Binary Tree Level Order Traversal II
 * Easy
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 */
class LC107_Binary_Tree_Level_Order_Traversal_II {
    /**
     * Version STD, same as LC102
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        // Same as LC102 before reversal
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        LC107_Binary_Tree_Level_Order_Traversal_II testCase = new LC107_Binary_Tree_Level_Order_Traversal_II();

        TreeNode T0 = null;
        assert testCase.levelOrderBottom(T0).equals(new ArrayList<>(

        )) : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.levelOrderBottom(T1).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ))) : "Example 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        });
        assert testCase.levelOrderBottom(T2).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(15, 7)),
                new ArrayList<>(Arrays.asList(9, 20)),
                new ArrayList<>(Arrays.asList(3))

        ))) : "Example 2";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                0,
                2, 4,
                1, null, 3, -1,
                5, 1, null, null, 6, null, 8, null
        });
        assert testCase.levelOrderBottom(T3).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(5, 1, 6, 8)),
                new ArrayList<>(Arrays.asList(1, 3, -1)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(0))
        ))) : "Additional 1";

        System.out.println("All passed");
    }
}

