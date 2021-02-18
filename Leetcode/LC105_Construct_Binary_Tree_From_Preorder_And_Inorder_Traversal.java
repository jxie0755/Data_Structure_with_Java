import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * P105 Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * <p>
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
class LC105_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    /**
     * Version A2
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        } else {
            int root_val = preorder[0];
            int in_idx = 0;
            for (int i = 0; i < inorder.length; i += 1) {
                if (inorder[i] == root_val) {
                    in_idx = i;
                    break;
                }
            }

            TreeNode T = new TreeNode(root_val);

            int[] L_list = Arrays.copyOfRange(inorder, 0, in_idx);
            if (L_list.length != 0) {
                preorder = Arrays.copyOfRange(preorder, 1, preorder.length);
                T.left = this.buildTree(preorder, L_list);
            }

            int[] R_list = Arrays.copyOfRange(inorder, in_idx + 1, inorder.length);
            if (R_list.length != 0) {
                preorder = Arrays.copyOfRange(preorder, 1, preorder.length);

                T.right = this.buildTree(preorder, R_list);
            }
            return T;
        }
    }

    public static void main(String[] args) {
        LC105_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal testCase = new LC105_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal();

        int[] p0 = new int[]{};
        int[] i0 = new int[]{};
        assert testCase.buildTree(p0, i0) == null : "Edge 0";

        int[] p1 = new int[]{1};
        int[] i1 = new int[]{1};
        assert testCase.buildTree(p1, i1).equals(TreeNode.genTree(new Object[]{
                1
        })) : "Edge 1";

        int[] p2 = new int[]{3, 9, 20, 15, 7};
        int[] i2 = new int[]{9, 3, 15, 20, 7};
        assert testCase.buildTree(p2, i2).equals(TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        })) : "Example 1";

        System.out.println("All passed");
    }
}

