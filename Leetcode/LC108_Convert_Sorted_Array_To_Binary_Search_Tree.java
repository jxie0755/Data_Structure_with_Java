/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * P108 Convert Sorted Array to Binary Search Tree
 * Easy
 * <p>
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
class LC108_Convert_Sorted_Array_To_Binary_Search_Tree {
    /**
     * Version A
     */
    public TreeNode sortedArrayToBST(int[] nums) {

    }

    public static void main(String[] args) {
        LC108_Convert_Sorted_Array_To_Binary_Search_Tree testCase = new LC108_Convert_Sorted_Array_To_Binary_Search_Tree();

        int[] A0 = new int[]{};
        assert testCase.sortedArrayToBST(A0).equals(null) : "Edge 0";

        int[] A1 = new int[]{};
        assert testCase.sortedArrayToBST(A1).equals(TreeNode.genTree(new Object[]{
                1
        })) : "Edge 1";

        int[] A2 = new int[]{-10, -3, 0, 5, 9};
        assert testCase.sortedArrayToBST(A1).equals(TreeNode.genTree(new Object[]{
                0,
                -3, 9,
                -10, null, 5, null
        })) : "Example 1";

        System.out.println("All passed");
    }
}

