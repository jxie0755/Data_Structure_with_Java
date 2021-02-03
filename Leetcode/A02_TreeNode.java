import java.util.HashMap;
import java.util.Map;

class A02_TreeNode {

}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    // Utilities for toString
    private static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Utilities for toString
    private static String layer(TreeNode T, String default_s, int L) {

        if (T == null) {
            return "N";
        }

        String s = Integer.toString(T.val);
        String space = stringMultiply(default_s, L);
        if (T.left != null && T.right != null) {
            return s + "\n" + space + layer(T.left, default_s, L + 1) + "\n" + space + layer(T.right, default_s, L + 1);
        } else if (T.left != null && T.right == null) {
            return s + "\n" + space + layer(T.left, default_s, L + 1) + "\n" + default_s + "N";
        } else if (T.left == null && T.right != null) {
            return s + "\n" + space + "N" + "\n" + space + layer(T.right, default_s, L + 1);
        } else {
            return s + "\n" + space + "N" + '\n' + space + "N";
        }
    }

    // static method to avoid print str instead of identity
    public static String showString(TreeNode A) {
        return layer(A, "  ", 1);
    }


    public static boolean isEqual(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A != null && B != null) {
            return A.val == B.val
                    && A.left.equals(B.left)
                    && A.right.equals(B.right);
        } else {
            return false;
        }
    }

    public boolean equals(TreeNode other) {

        // this look very complicated to avoid when left/right is null and cannot be called equals.
        if (this.left == null && other.left == null && this.right == null && other.right == null) {
            return this.val == other.val;
        } else if (this.left != null && other.left != null && this.right != null && other.right != null) {
            return this.val == other.val && this.left.equals(other.left) && this.right.equals(other.right);
        } else if (this.left != null && other.left != null && this.right == null && other.right == null) {
            return this.val == other.val && this.left.equals(other.left);
        } else if (this.left == null && other.left == null && this.right != null && other.right != null) {
            return this.val == other.val && this.right.equals(other.right);
        } else {
            return false;
        }
    }

    /**
     * To generate a perfect binary tree according to a non-empty list of values
     * The lst must be all filled, even the branch is empty, then use null to suggest the empty treeNode
     * Starting idx = 0, and every branch idx of i is i*2+1 (left) and i*2+2 (right)
     */
    public static TreeNode genTree(Object[] treelist, int idx) {

        if (treelist.length >= idx + 1 && treelist[idx] != null) {
            TreeNode node = new TreeNode((int) treelist[idx]);
            node.left = genTree(treelist, idx * 2 + 1);
            node.right = genTree(treelist, idx * 2 + 2);
            return node;
        }
        return null;
    }

    // Overload for default value
    public static TreeNode genTree(Object[] treelist) {
        return genTree(treelist, 0);
    }

    public static void main(String[] args) {

        TreeNode A1 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                4, 5, null, 7
        });


        TreeNode A2 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                4, 5, null, 7
        });

        // Test showString
        System.out.println(TreeNode.showString(A1));
        // 1
        //   2
        //     4
        //       N
        //       N
        //     5
        //       N
        //       N
        //   3
        //     N
        //     7
        //       N
        //       N


        // Test identity
        // assert A1 != A2 : "Check Identify";

        // Test equals
        // assert A1.equals(A2) : "Check equals";


        // Test hash
        Map<TreeNode, Integer> hmp = new HashMap<>(Map.ofEntries(
                Map.entry(A1, 1),
                Map.entry(A2, 2)
        ));
        System.out.println(hmp);
        // >>> {TreeNode@396a51ab=2, TreeNode@5034c75a=1}


        // Test genTree

        // Empty Tree
        TreeNode t1 = TreeNode.genTree(new Object[]{});
        System.out.println(TreeNode.showString(t1));
        // N

        // Signle Tree
        TreeNode t2 = TreeNode.genTree(new Object[]{1});
        System.out.println(TreeNode.showString(t2));
        // 1
        //   N
        //   N

        // multi-branch tree
        TreeNode t3 = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                null, 14, 15, null
        });
        System.out.println(TreeNode.showString(t3));
        // 1
        //   2
        //     N
        //     14
        //       N
        //       N
        //   3
        //     15
        //       N
        //       N
        //     N
    }
}
