package FB;

import java.util.*;

public class SerializeAndDeserializeABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public void Serialize(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // preorder traversal
        res.add(root.val);
        Serialize(root.left, res);
        Serialize(root.right, res);
    }

    public TreeNode Deserialize(List<Integer> nums) {
        Queue<Integer> q = new LinkedList<>();
        for (int n: nums) {
            q.offer(n);
        }
        return getNode(q);
    }

    public TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) {
            return null;
        }
        int val = q.poll();
        TreeNode cur = new TreeNode(val);
        Queue<Integer> small = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < val) {
            small.offer(q.poll());
        }
        cur.left = getNode(small);
        cur.right = getNode(q);
        return cur;
    }

    public static void main(String[] args) {

        // serialize
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(10);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        List<Integer> res = new ArrayList<>();
        new SerializeAndDeserializeABinarySearchTree().Serialize(t1, res);
        for (Integer n: res) {
            System.out.println(n);
        }

        // deserialize
        TreeNode root = new SerializeAndDeserializeABinarySearchTree().Deserialize(res);
        System.out.print(root.val);
    }
}
