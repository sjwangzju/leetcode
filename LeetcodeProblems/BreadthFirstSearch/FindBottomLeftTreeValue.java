package BreadthFirstSearch;

/**
 * Created by sjwang on 10/11/2018.
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 *
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] tmp = findLeft(root, 0);
        return tmp[0];
    }

    public int[] findLeft(TreeNode root, int level) {
        int[] res = new int[2];
        if (root.left == null && root.right == null) {
            res[0] = root.val; res[1] = level;
            return res;
        } else if (root.right == null) {
            return findLeft(root.left, level + 1);
        } else if (root.left == null) {
            return findLeft(root.right, level + 1);
        }
        int[] left = findLeft(root.left, level + 1);
        int[] right = findLeft(root.right, level + 1);
        if (right[1] > left[1]) {
            return right;
        }
        return left;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(2);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(t1));
    }
}
