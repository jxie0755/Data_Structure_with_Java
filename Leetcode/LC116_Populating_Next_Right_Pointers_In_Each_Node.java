import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * LC116 Populating Next Right Pointers in Each Node
 * Medium
 * <p>
 * You are given a perfect binary tree where:
 * 1. all leaves are on the same level
 * 2. every parent has two children.
 * <p>
 * Note:
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */


class LC116_Populating_Next_Right_Pointers_In_Each_Node {
    /**
     * Version A
     * Modified from levelOrderTraversal
     */
    public Node connect(Node root) {
        if (root != null) {
            List<Node> current = new ArrayList<>(Arrays.asList(root));
            int L = 1;

            while (!current.isEmpty()) {

                for (int lidx = 0; lidx < L - 1; lidx += 1) {
                    current.get(lidx).next = current.get(lidx + 1);
                }


                List<Node> next_layer = new ArrayList<>(Arrays.asList());

                for (Node node : current) {
                    if (node.left != null && node.right != null) {
                        next_layer.add(node.left);
                        next_layer.add(node.right);
                    }
                }

                L *= 2;
                current = next_layer;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        LC116_Populating_Next_Right_Pointers_In_Each_Node testCase = new LC116_Populating_Next_Right_Pointers_In_Each_Node();


        Node A = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null),
                        null),
                new Node(3,
                        new Node(6, null, null, null),
                        new Node(7, null, null, null),
                        null),
                null);

        Node B = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null),
                        null),
                new Node(3,
                        new Node(6, null, null, null),
                        new Node(7, null, null, null),
                        null),
                null);
        B.left.next = B.right;
        B.left.left.next = B.left.right;
        B.left.right.next = B.right.left;
        B.right.left.next = B.right.right;

        assert Node.isEqual(testCase.connect(A), B) : "Example 1";

        System.out.println("All passed");
    }
}

