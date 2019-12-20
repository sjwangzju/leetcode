package FullTime.Facebook;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x; }
    }

    // Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
    //
    // Thoughts:
    // 1. BST inorder traversal
    // 2. two variables to store first and last node
    //
    // time: O(N), space: O(N)
    Node first = null, last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        // connect first node with last node
        first.left = last;
        last.right = first;
        return first;
    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        // connect current node with last node
        if (last != null) {
            root.left = last;
            last.right = root;
        } else {
            first = root;
        }
        last = root;
        inorder(root.right);
    }
}
