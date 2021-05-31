import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * LC129 Sum Root to Leaf Numbers
 * Medium
 *
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 */
public class LC129_Sum_Root_To_Leaf_Numbers {

    List<Integer> all_path_num = new ArrayList<>(Arrays.asList());

    /**
     * Version B
     */
    public int sumNumbers(TreeNode root) {
        this.convert_all_path(0, root);
        System.out.println(this.all_path_num);
        int result = 0;
        for (int i : all_path_num) {
            result += i;
        }
        this.all_path_num.clear();
        return result;
    }

    private void convert_all_path(int cur_num, TreeNode root) {

        if (root == null) {

        } else if (root.left == null && root.right == null) {
            cur_num = cur_num * 10 + root.val;
            all_path_num.add(cur_num);
        } else {
            if (root.left != null) {
                this.convert_all_path(cur_num * 10 + root.val, root.left);
            }
            if (root.right != null) {
                this.convert_all_path(cur_num * 10 + root.val, root.right);
            }
        }
    }

    public static void main(String[] args) {
        LC129_Sum_Root_To_Leaf_Numbers testCase = new LC129_Sum_Root_To_Leaf_Numbers();

        TreeNode T1 = TreeNode.genTree(new Object[]{
                1,
                2, 3
        });
        assert testCase.sumNumbers(T1) == 25 : "Example 1, 12 + 13 = 25";

        TreeNode T2 = TreeNode.genTree(new Object[]{
                4,
                9, 0,
                5, 1, null, null
        });
        assert testCase.sumNumbers(T2) == 1026 : "Example 1, 495 + 491 + 40 = 1026";

        System.out.println("All passed");
    }
}

