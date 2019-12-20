package FullTime.OCI;

public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // pre-order
    // time: O(N), space: O(N)

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    int i = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        return dfs(data.split(" "));
    }

    public TreeNode dfs(String[] strs) {
        if (strs[i].equals("null")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[i++]));
        root.left = dfs(strs);
        root.right = dfs(strs);
        return root;
    }
}
