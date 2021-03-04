import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * P113 Path Sum II
 * Medium
 *
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 */
public class LC113_Path_Sum_II {
    List<List<Integer>> VALID_PATHS = new ArrayList<>(Arrays.asList());

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.validPathCollector(root, targetSum, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>(VALID_PATHS);
        VALID_PATHS.clear();
        return ans;
    }

    private void validPathCollector(TreeNode root, int target, List<Integer> path_so_far) {
        if (root == null) {
            ;
        } else if (root.left == null && root.right == null) { // isLeaf
            List<Integer> new_path = new ArrayList<>(path_so_far);
            new_path.add(root.val);
            int sum_val = 0;
            for (int val : new_path) {
                sum_val += val;
            }
            if (sum_val == target) {
                VALID_PATHS.add(new_path);
            }
        } else {
            List<Integer> left_path = new ArrayList<>(path_so_far);
            List<Integer> right_path = new ArrayList<>(path_so_far);
            left_path.add(root.val);
            right_path.add(root.val);
            this.validPathCollector(root.left, target, left_path);
            this.validPathCollector(root.right, target, right_path);
        }
    }

    public static void main(String[] args) {
        LC113_Path_Sum_II testCase = new LC113_Path_Sum_II();

        TreeNode T0 = null;
        List<List<Integer>> A0 = new ArrayList<>(Arrays.asList());
        assert testCase.pathSum(T0, 0).equals(A0) : "Edge 0";


        TreeNode T1 = TreeNode.genTree(new Object[]{
                1
        });
        List<List<Integer>> A1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ));
        assert testCase.pathSum(T1, 1).equals(A1) : "Edge 1";


        TreeNode T2 = TreeNode.genTree(new Object[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, 5, 1
        });
        List<List<Integer>> A2 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(5, 4, 11, 2)),
                new ArrayList<>(Arrays.asList(5, 8, 4, 5))
        ));
        assert testCase.pathSum(T2, 22).equals(A2) : "Example 1";

        System.out.println("All passed");
    }
}

