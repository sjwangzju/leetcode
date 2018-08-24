package BinarySearch;

/**
 * Created by sjwang on 07/24/2018.
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(leftDepth(root) == rightDepth(root)) {
            return (1 << leftDepth(root))  - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int leftDepth(TreeNode root){
        int n = 0;
        while(root != null){
            root = root.left;
            n++;
        }
        return n;
    }
    public int rightDepth(TreeNode root){
        int n = 0;
        while(root != null){
            root = root.right;
            n++;
        }
        return n;
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        TreeNode t33 = new TreeNode(6);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t22.left = t33;
        System.out.println(new CountCompleteTreeNodes().countNodes(t1));
    }
}
