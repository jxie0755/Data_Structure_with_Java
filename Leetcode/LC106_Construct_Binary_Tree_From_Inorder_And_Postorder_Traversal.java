import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * P106 Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
class LC106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {
    /**
     * Version A2
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // convert int[] to List<Integer>
        List<Integer> inorderList = new ArrayList<>();
        for (int i : inorder) {
            inorderList.add(i);
        }

        List<Integer> postorderList = new ArrayList<>();
        for (int i : postorder) {
            postorderList.add(i);
        }

        // return with overload function
        return this.buildTree(inorderList, postorderList);
    }

    public TreeNode buildTree(List<Integer> inorderList, List<Integer> postorderList) {
        if (inorderList.isEmpty()) {
            return null;
        }

        int root_val = postorderList.remove(postorderList.size() - 1); // pop
        int in_idx = inorderList.indexOf(root_val);
        TreeNode T = new TreeNode(root_val);


        List<Integer> R_inorderList = inorderList.subList(in_idx + 1, inorderList.size());
        if (!postorderList.isEmpty() && R_inorderList.contains(postorderList.get(postorderList.size() - 1))) {
            T.right = this.buildTree(R_inorderList, postorderList);
        }

        List<Integer> L_inorderList = inorderList.subList(0, in_idx);
        if (!postorderList.isEmpty() && L_inorderList.contains(postorderList.get(postorderList.size() - 1))) {
            T.left = this.buildTree(L_inorderList, postorderList);
        }

        return T;
    }

    public static void main(String[] args) {
        LC106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal testCase = new LC106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal();

        int[] i0 = new int[]{};
        int[] p0 = new int[]{};
        assert testCase.buildTree(i0, p0) == null : "Edge 0";

        int[] i1 = new int[]{1};
        int[] p1 = new int[]{1};
        assert testCase.buildTree(i1, p1).equals(TreeNode.genTree(new Object[]{
                1
        })) : "Edge 1";

        int[] i2 = new int[]{9, 3, 15, 20, 7};
        int[] p2 = new int[]{9, 15, 7, 20, 3};
        assert testCase.buildTree(i2, p2).equals(TreeNode.genTree(new Object[]{
                3,
                9, 20,
                null, null, 15, 7
        })) : "Example 1";

        int[] i3 = new int[]{4, 2, 5, 1, 6, 3, 7};
        int[] p3 = new int[]{4, 5, 2, 6, 7, 3, 1};
        assert testCase.buildTree(i3, p3).equals(TreeNode.genTree(new Object[]{
                1,
                2, 3,
                4, 5, 6, 7
        })) : "Additional 1";

        System.out.println("All passed");
    }
}

