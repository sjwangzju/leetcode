package Indeed;

public class RootLeafMinCost {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int findMinCost(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        dfs(root, min, 0);
        return min[0];
    }

    public void dfs(TreeNode root, int[] min, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min[0] = Math.min(min[0], root.val + sum);
            return;
        }
        dfs(root.left, min, sum + root.val);
        dfs(root.right, min, sum + root.val);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(10);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(-11);
        TreeNode t33 = new TreeNode(-15);

        t1.left = t21; t1.right = t22;
        t21.left = t31; t22.left = t32; t22.right = t33;
        System.out.println(new RootLeafMinCost().findMinCost(t1));
    }

}
