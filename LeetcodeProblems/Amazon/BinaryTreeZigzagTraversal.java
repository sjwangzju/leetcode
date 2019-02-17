package Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * zigzag level order
     * list.add(0, n) or list.add(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.offer(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (flag) {
                    tmp.add(t.val);
                } else {
                    tmp.add(0, t.val);
                }
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }

            flag = !flag;
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(10);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(-11);
        TreeNode t33 = new TreeNode(5);

        t1.left = t21; t1.right = t22;
        t21.left = t31;
        t22.left = t32; t22.right = t33;

        System.out.println(new BinaryTreeZigzagTraversal().zigzagLevelOrder(t1));
    }

}
