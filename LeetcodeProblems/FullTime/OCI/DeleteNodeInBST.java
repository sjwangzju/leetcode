package FullTime.OCI;

public class DeleteNodeInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
    // Basically, the deletion can be divided into two stages:
    // 1. Search for a node to remove.
    // 2. If the node is found, delete the node.
    //
    // Note: Time complexity should be O(height of tree).
    //
    // time: O(H), space: O(H), H is height of tree
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }
            // node has right child
            else if (root.right != null) {
                root.val = getSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // node has left child
            else {
                root.val = getPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // smallest node larger than node
    public int getSuccessor(TreeNode node) {
        TreeNode tmp = node.right;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.val;
    }

    // largest node smaller than node
    public int getPredecessor(TreeNode node) {
        TreeNode tmp = node.left;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.val;
    }
}
