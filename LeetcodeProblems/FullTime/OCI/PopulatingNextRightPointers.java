package FullTime.OCI;

public class PopulatingNextRightPointers {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // time: O(N), space: O(1)
    public Node connect(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0), tmp = dummy;
        // first node at current level
        Node first = root;
        while (first != null) {
            Node cur = first;
            // same level
            while (cur != null) {
                if (cur.left != null) {
                    tmp.next = cur.left;
                    tmp = tmp.next;
                }
                if (cur.right != null) {
                    tmp.next = cur.right;
                    tmp = tmp.next;
                }
                cur = cur.next;
            }
            // proceed to next level
            first = dummy.next;
            dummy.next = null;
            tmp = dummy;
        }
        return root;
    }
}
