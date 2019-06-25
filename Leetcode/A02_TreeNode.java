import java.util.HashMap;
import java.util.Map;

public class A02_TreeNode {

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
    private static String stringMultiply(String s, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Utilities for toString
    private static String layer(TreeNode T, int L) {

        if (T == null) {
            return "N";
        }

        String s = Integer.toString(T.val);
        String space = stringMultiply("  ", L);
        if (T.left != null && T.right != null) {
            return s + "\n" + space + layer(T.left, L + 1) + "\n" + space + layer(T.right, L + 1);
        } else if (T.left != null && T.right == null) {
            return s + "\n" + space + layer(T.left, L + 1) + "\n" + space + "N";
        } else if (T.left == null && T.right != null) {
            return s + "\n" + space + "N" + "\n" + space + layer(T.right, L + 1);
        } else {
            return s + "\n" + space + "N" + '\n' + space + "N";
        }
    }

    // static method to avoid print str instead of identity
    public static String showString(TreeNode A) {
        return layer(A, 1);
    }


    public boolean equals(TreeNode other) {

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
     */
    public static TreeNode genTree(Object[] treelist, int idx) {

        if (idx <= treelist.length && treelist[idx - 1] != null) {
            TreeNode node = new TreeNode((int)treelist[idx - 1]);
            node.left = genTree(treelist, idx * 2);
            node.right = genTree(treelist, idx * 2 + 1);
            return node;
        }
        return null;
    }


    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode E = new TreeNode(4);
        TreeNode F = new TreeNode(5);
        TreeNode G = new TreeNode(6);
        TreeNode H = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = E;
        B.right = F;
        C.right = H;

        TreeNode A2 = new TreeNode(1);
        TreeNode B2 = new TreeNode(2);
        TreeNode C2 = new TreeNode(3);
        TreeNode E2 = new TreeNode(4);
        TreeNode F2 = new TreeNode(5);
        TreeNode G2 = new TreeNode(6);
        TreeNode H2 = new TreeNode(7);
        A2.left = B2;
        A2.right = C2;
        B2.left = E2;
        B2.right = F2;
        C2.right = H2;

        // Test showString
        System.out.println(TreeNode.showString(A));
        // >>>
        // 1
        // 2
        //   4
        //     N
        //     N
        //   5
        //     N
        //     N
        // 3
        //   N
        //   7
        //     N
        //     N

        // Test equals
        assert A.equals(A2);

        // Test hash
        Map<TreeNode, Integer> hmp = new HashMap<>(Map.ofEntries(
                Map.entry(A, 1),
                Map.entry(C, 2)
        ));
        System.out.println(hmp);
        // >>> {TreeNode@58651fd0=2, TreeNode@735b5592=1}


        // Test genTree
        TreeNode X = TreeNode.genTree(new Object[]{
                1,
                2, 3,
                null,4,null,5
        }, 1);

        System.out.println(TreeNode.showString(X));

    }
}
