package FullTime.FB;

/**
 * DFS
 *
 * time: O(logN)
 * space: O(logN)
 */
public class LC285_InorderSuccessorInBST_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Solution1: recursive
    // time: O(logN)
    // space: O(logN)
    TreeNode res = null;
    public TreeNode inorderSuccessorI(TreeNode root, TreeNode p) {
        search(root, p);
        return res;
    }

    public void search(TreeNode node, TreeNode p) {
        if (node == null) return;
        if (node.val <= p.val) {
            search(node.right, p);
            return;
        }
        res = node;
        search(node.left, p);
    }


    // Solution2: Iterative
    // time: O(logN)
    // space: O(1)
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(6);
        TreeNode t31 = new TreeNode(2);
        TreeNode t32 = new TreeNode(4);
        TreeNode t41 = new TreeNode(1);

        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t31.left = t41;
        TreeNode res = new LC285_InorderSuccessorInBST_M().inorderSuccessorII(t1, t22);
        System.out.print(res.val);
    }
}
