package FB;

import java.util.*;

public class LC314BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * BFS
     *
     * time: O(N), N is the number of nodes
     * space: O(N)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        int min = 0;
        int max = 0;

        if (root == null) return res;

        q.offer(root);
        index.offer(0);

        while (!q.isEmpty()) {
            int siz = q.size();
            for (int i = 0; i < siz; i++) {
                TreeNode t = q.poll();
                int curIndex = index.poll();

                if (!map.containsKey(curIndex)) {
                    map.put(curIndex, new LinkedList<>());
                }
                map.get(curIndex).add(t.val);

                if (t.left != null) {
                    q.offer(t.left);
                    index.offer(curIndex - 1);
                    min = Math.min(min, curIndex - 1);
                }

                if (t.right != null) {
                    q.offer(t.right);
                    index.offer(curIndex + 1);
                    max = Math.max(max, curIndex + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(new LinkedList<>(map.get(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(0);
        TreeNode t33 = new TreeNode(1);
        TreeNode t34 = new TreeNode(7);
        TreeNode t41 = new TreeNode(10);

        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        t32.right = t41;

        List<List<Integer>> res = new LC314BinaryTreeVerticalOrderTraversal().verticalOrder(t1);
        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
