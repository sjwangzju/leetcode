package FullTime.FB;

/**
 * BST in-place transform to doubly-linked list
 *
 * -> in-order traversal
 *
 * time: O(N), N is the num of nodes in BST
 * space: O(N), depth of the recursive call stack -> best: O(logN), worst: O(N)
 *
 */
public class LC426_ConvertBinarySearchTreeToSortedDoublyLinkedList_M {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        DFS_inorder(root);
        last.right = first;
        first.left = last;
        return first;
    }

    public void DFS_inorder(Node cur) {
        if (cur == null) return;

        // in-order traversal
        DFS_inorder(cur.left);

        if (first == null) first = cur;
        if (last != null) {
            last.right = cur;
            cur.left = last;
        }
        last = cur;

        DFS_inorder(cur.right);
    }

    public static void main(String[] args) {
        Node n31 = new Node(1, null, null);
        Node n32 = new Node(3, null, null);
        Node n21 = new Node(2, n31, n32);
        Node n22 = new Node(5, null, null);
        Node n1 = new Node(4, n21, n22);

        Node tmp = new LC426_ConvertBinarySearchTreeToSortedDoublyLinkedList_M().treeToDoublyList(n1);
        System.out.println(tmp.val);
    }
}
