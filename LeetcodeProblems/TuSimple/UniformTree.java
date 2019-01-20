package TuSimple;

public class UniformTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int isUniform(TreeNode root) {
        if (root == null) return 0;
        int[] cnt = new int[1];
        uniform(root, root.val, cnt);
        return cnt[0];
    }

    public void uniform(TreeNode root, int val, int[] cnt) {
        if (root == null || root.val != val) return;
        cnt[0]++;
        uniform(root.left, val, cnt);
        uniform(root.right, val, cnt);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(3);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        System.out.println(new UniformTree().isUniform(t1));
    }
}
