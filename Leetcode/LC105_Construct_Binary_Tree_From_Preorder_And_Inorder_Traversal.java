import java.util.ArrayList;
import java.util.List;

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

        // convert int[] to List<Integer>
        List<Integer> preorderList = new ArrayList<>();
        for (int i : preorder) {
            preorderList.add(i);
        }

        List<Integer> inorderList = new ArrayList<>();
        for (int i : inorder) {
            inorderList.add(i);
        }

        // return with overload function
        return this.buildTree(preorderList, inorderList);
    }

    /**
     * Helper, overload with List<> preorder and inorder
     */
    public TreeNode buildTree(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.isEmpty()) {
            return null;
        }

        int root_val = preorderList.remove(0); // pop
        int in_idx = inorderList.indexOf(root_val);
        TreeNode T = new TreeNode(root_val);

        List<Integer> L_inorderList = inorderList.subList(0, in_idx);
        T.left = this.buildTree(preorderList, L_inorderList);

        List<Integer> R_inorderList = inorderList.subList(in_idx + 1, inorderList.size());
        T.right = this.buildTree(preorderList, R_inorderList);

        return T;
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

        int[] p3 = new int[]{3, 1, 2, 4};
        int[] i3 = new int[]{1, 2, 3, 4};
        assert testCase.buildTree(p3, i3).equals(TreeNode.genTree(new Object[]{
                3,
                1, 4,
                null, 2, null, null
        })) : "Additional 1";

        int[] p4 = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] i4 = new int[]{4, 2, 5, 1, 6, 3, 7};
        assert testCase.buildTree(p4, i4).equals(TreeNode.genTree(new Object[]{
                1,
                2, 3,
                4, 5, 6, 7
        })) : "Additional 2";

        System.out.println("All passed");
    }
}

