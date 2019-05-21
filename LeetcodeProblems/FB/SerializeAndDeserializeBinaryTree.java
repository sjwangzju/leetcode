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

    /**
     * BFS, time: O(N), N is the number of nodes in the tree
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serializeBFS(TreeNode root) {
        if (root == null) return "";
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
    public TreeNode deserializeBFS(String data) {
        if (data == null || data.length() == 0) return null;
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


    /**
     * DFS
     * @param root
     * @return
     */
    public String serializeDFS(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        serialize_dfs(root, res);
        return res.toString();
    }

    public void serialize_dfs(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null ");
            return;
        }
        int val = root.val;
        res.append(val + " ");
        serialize_dfs(root.left, res);
        serialize_dfs(root.right, res);
    }

    public TreeNode deserializeDFS(String data) {
        if (data == null || data.length() == 0) return null;
        String[] str = data.split(" ");
        int[] index = new int[1];
        return deserialize_dfs(str, index);
    }

    public TreeNode deserialize_dfs(String[] str, int[] index) {
        String cur = str[index[0]];
        if (cur.equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(cur));
        index[0]++;
        t.left = deserialize_dfs(str, index);
        t.right = deserialize_dfs(str, index);
        return t;
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
//        String res = new SerializeAndDeserializeBinaryTree().serializeDFS(t1);
        System.out.println(res);
////        TreeNode root = new SerializeAndDeserializeBinaryTree().deserializeBFS(res);
//        TreeNode root = new SerializeAndDeserializeBinaryTree().deserializeDFS(res);
//        System.out.print(root.val);
    }
}
