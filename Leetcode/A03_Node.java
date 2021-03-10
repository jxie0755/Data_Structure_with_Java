class A03_Node {
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static boolean isEqual(Node self, Node other) {
        if (self != null && other != null) {
            return self.val == other.val &&
                    Node.isEqual(self.left, other.left) &&
                    Node.isEqual(self.right, other.right) &&
                    Node.isEqual(self.next, other.next);
        } else if (self == null && other == null) {
            return true;
        } else {
            return false;
        }
    }
}
