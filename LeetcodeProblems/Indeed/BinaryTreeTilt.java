package Indeed;

public class BinaryTreeTilt {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] += Math.abs(left - right);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        System.out.println(new BinaryTreeTilt().findTilt(t1));
    }

}
