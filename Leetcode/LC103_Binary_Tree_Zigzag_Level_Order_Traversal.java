import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * P103 Binary Tree Zigzag Level Order Traversal
 * Medium
 * <p>
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 */
class LC103_Binary_Tree_Zigzag_Level_Order_Traversal {
    /**
     * Version A
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList());

        if (root == null) {
            return result;
        }

        List<TreeNode> layer = new ArrayList<>(Arrays.asList(root));
        boolean REV = false;
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
            if (REV) {
                Collections.reverse(node_vals);
            }
            REV = !REV;
            result.add(node_vals);

        }
        return result;
    }


    public static void main(String[] args) {
        LC103_Binary_Tree_Zigzag_Level_Order_Traversal testCase = new LC103_Binary_Tree_Zigzag_Level_Order_Traversal();


        TreeNode T0 = null;
        assert testCase.zigzagLevelOrder(T0).equals(new ArrayList<>(

        )) : "Edge 0";

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        assert testCase.zigzagLevelOrder(T1).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ))) : "Example 1";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        });
        assert testCase.zigzagLevelOrder(T2).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(20, 9)),
                new ArrayList<>(Arrays.asList(15, 7))
        ))) : "Example 2";

        TreeNode T3 = TreeNode.genTree(new Object[]{
                0,
                2, 4,
                1, null, 3, -1,
                5, 1, null, null, 6, null, 8, null
        });
        assert testCase.zigzagLevelOrder(T3).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0)),
                new ArrayList<>(Arrays.asList(4, 2)),
                new ArrayList<>(Arrays.asList(1, 3, -1)),
                new ArrayList<>(Arrays.asList(8, 6, 1, 5))
        ))) : "Additional 1";

        System.out.println("All passed");
    }
}

