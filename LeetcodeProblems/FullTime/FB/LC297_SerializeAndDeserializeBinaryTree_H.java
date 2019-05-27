package FullTime.FB;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC297_SerializeAndDeserializeBinaryTree_H {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Codec {

        // Encodes a tree to a single string using pre-order traversal
        public String serialize(TreeNode root) {
            StringBuilder res = new StringBuilder();
            dfs_preorder(root, res);

            return res.toString();
        }

        public void dfs_preorder(TreeNode node, StringBuilder res) {
            if (node == null) {
                res.append("null ");
                return;
            }
            res.append(node.val + " ");
            dfs_preorder(node.left, res);
            dfs_preorder(node.right, res);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strs = data.split(" ");
            List<String> list = new LinkedList<>(Arrays.asList(strs));

            return buildTree(list);
        }

        public TreeNode buildTree(List<String> list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }

            TreeNode cur = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            cur.left = buildTree(list);
            cur.right = buildTree(list);
            return cur;
        }

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;

        // serialize
        String serializedTree = new Codec().serialize(t1);
        System.out.println(serializedTree);

        // deserialize
        TreeNode tree = new Codec().deserialize(serializedTree);
        System.out.println(tree.val);
    }
}
