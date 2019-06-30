package FullTime.FB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * same as LC297 - DFS preorder traversal
 *
 * time: O(N)
 * space: O(N)
 */
public class LC449_SerializeAndDeserializeBST_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        preorder(res, root);
        return res.toString();
    }

    public void preorder(StringBuilder res, TreeNode node) {
        if (node == null) {
            res.append("null ");
            return;
        }
        res.append(node.val + " ");
        preorder(res, node.left);
        preorder(res, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(" ");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return build(list);
    }

    public TreeNode build(List<String> list) {
        String cur = list.get(0);
        list.remove(0);

        if (cur.equals("null")) {
            return null;
        }
        TreeNode tmp = new TreeNode(Integer.parseInt(cur));
        tmp.left = build(list);
        tmp.right = build(list);
        return tmp;
    }

    public static void main(String[] args) {
        TreeNode t1 =  new TreeNode(8);
        TreeNode t21 =  new TreeNode(3);
        TreeNode t22 =  new TreeNode(10);
        TreeNode t31 =  new TreeNode(5);
        TreeNode t32 =  new TreeNode(9);
        TreeNode t41 =  new TreeNode(4);

        t1.left = t21; t1.right = t22;
        t21.right = t31; t22.left = t32;
        t31.left = t41;
        String res = new LC449_SerializeAndDeserializeBST_M().serialize(t1);
        System.out.println(res);

        TreeNode root = new LC449_SerializeAndDeserializeBST_M().deserialize(res);
        System.out.print(root.val);
    }
}
