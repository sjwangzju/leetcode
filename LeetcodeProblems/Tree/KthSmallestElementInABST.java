package Tree;

/**
 * Created by sjwang on 07/28/2018.
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        if(num(root.left) + 1 == k) return root.val;
        if(num(root.left) >= k) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - num(root.left) - 1);
    }
    public int num(TreeNode root) {
        if(root == null) return 0;
        return 1 + num(root.left) + num(root.right);
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
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(6);
        TreeNode t31 = new TreeNode(2);
        TreeNode t32 = new TreeNode(4);
        TreeNode t41 = new TreeNode(1);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t31.left = t41;
        System.out.println(new KthSmallestElementInABST().kthSmallest(t1, 2));
    }
}
