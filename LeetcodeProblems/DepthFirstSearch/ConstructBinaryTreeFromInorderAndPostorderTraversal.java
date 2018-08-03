package DepthFirstSearch;

/**
 * Created by sjwang on 08/03/2018.
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || inorder == null || postorder.length == 0 || postorder == null) return null;
        int flag = postorder.length - 1;
        return build(inorder, postorder, 0, postorder.length - 1, flag);
    }
    public TreeNode build(int[] inorder, int[] postorder, int lo, int hi, int flag) {
        if(lo > hi || flag < 0) return null;
        int root = postorder[flag], i;
        TreeNode t = new TreeNode(root);
        for(i = 0; i < inorder.length; i++) {
            if(inorder[i] == root) break;
        }
        t.left = build(inorder, postorder, lo, i - 1, flag - 1 - (hi - i));
        t.right = build(inorder, postorder, i + 1, hi, flag - 1);
        return t;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        System.out.println(new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder));
    }
}
