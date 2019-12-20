package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;

public class aaaSerializeAndDeserialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Serialize and deserialize binary tree (each node <= 2 children)
     *
     * e.g. "1 2 null null 3 4 null null 5 null null"
     *
     * Thoughts:
     * 1. pre-order traversal
     *
     *
     * time: O(N), space: O(N)
     */

    // Encodes a tree to a single string.
    public String serializeI(TreeNode root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder();
        dfsI(root, s);
        return s.toString();
    }

    public void dfsI(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null").append(" ");
            return;
        }
        s.append(root.val).append(" ");
        dfsI(root.left, s);
        dfsI(root.right, s);
    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserializeI(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(" ");
        return helpI(strs);
    }

    public TreeNode helpI(String[] strs) {
        if (strs[i].equals("null")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[i++]));
        root.left = helpI(strs);
        root.right = helpI(strs);
        return root;
    }



    /**
     * Serialize and deserialize N-nary tree (each node has at most N children)
     *
     * Thoughts:
     * 1. pre-order traversal
     * 2. node.val + " " + (num of children) + " "
     *
     *
     * time: O(N), space: O(N)
     */
    public static class Node {
        int val;
        List<Node> children;
        Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }

    // Encodes a tree to a single string.
    public String serializeII(Node root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder();
        dfs(root, s);
        return s.toString();
    }

    public void dfs(Node root, StringBuilder s) {
        if (root == null) {
            s.append("null").append(" ");
            return;
        }
        s.append(root.val).append(" ").append(root.children.size()).append(" ");

        for (Node n: root.children) {
            dfs(n, s);
        }
    }

    int k = 0;
    // Decodes your encoded data to tree.
    public Node deserializeII(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(" ");
        return helpII(strs);
    }

    public Node helpII(String[] strs) {
        if (strs[k].equals("null")) {
            k++;
            return null;
        }
        Node root = new Node(Integer.parseInt(strs[k++]), null);

        List<Node> list = new ArrayList<>();
        int num = Integer.parseInt(strs[k++]);
        for (int j = 0; j < num; j++) {
            list.add(helpII(strs));
        }
        root.children = list;
        return root;
    }



    /**
     * Serialize and deserialize BST
     *
     * e.g. "2 1 3"
     *
     * Thoughts:
     * 1. pre-order traversal
     * 2. difference from BT
     *      a. serialize part:  if (root == null) return. don't need null
     *      b. deserialize part: define lo & hi boundary when recursion
     *
     * time: O(N), space: O(N)
     */

    // Encodes a tree to a single string.
    public String serializeIII(TreeNode root) {
        StringBuilder s = new StringBuilder();
        dfsIII(root, s);
        return s.toString();
    }

    public void dfsIII(TreeNode root, StringBuilder s) {
        if (root == null) return;
        s.append(root.val).append(" ");
        dfsIII(root.left, s);
        dfsIII(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeIII(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(" ");
        return helpIII(strs, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int index = 0;
    public TreeNode helpIII(String[] strs, int lo, int hi) {
        if (index == strs.length) return null;
        int cur = Integer.parseInt(strs[index]);
        if (cur <= lo || cur >= hi) return null;

        TreeNode root = new TreeNode(cur);
        index++;
        root.left = helpIII(strs, lo, root.val);
        root.right = helpIII(strs, root.val, hi);
        return root;
    }

}
