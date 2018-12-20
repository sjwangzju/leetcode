package FB;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serializeBFS(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        res.append(root.val);
        while (!pq.isEmpty()) {
            TreeNode cur = pq.poll();
            if (cur.left == null) {
                res.append(" null");
            } else {
                pq.offer(cur.left);
                res.append(" " + cur.left.val);
            }

            if (cur.right == null) {
                res.append(" null");
            } else {
                pq.offer(cur.right);
                res.append(" " + cur.right.val);
            }
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (str[i].equals("null")) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(cur.left);
            }
            i++;

            if (str[i].equals("null")) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {

        // serialize
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(10);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        TreeNode t41 = new TreeNode(6);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t32;
        t31.left = t41;
//        System.out.println(new SerializeAndDeserializeBinaryTree().getHeight(t1));
        String res = new SerializeAndDeserializeBinaryTree().serializeBFS(t1);
        System.out.println(res);
        TreeNode root = new SerializeAndDeserializeBinaryTree().deserialize(res);
        System.out.print(root.val);
    }
}
