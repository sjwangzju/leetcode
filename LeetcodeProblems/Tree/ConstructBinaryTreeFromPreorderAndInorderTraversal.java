package Tree;

/**
 * Created by sjwang on 07/27/2018.
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder == null || inorder.length == 0 || inorder == null) return null;
        return build(0, inorder.length - 1, 0, preorder, inorder);
    }
    public TreeNode build(int in_s, int in_end, int pre_s, int[] preorder, int[] inorder) {
        if(in_s > in_end || pre_s >= preorder.length) return null;
        int root = preorder[pre_s], i;
        TreeNode T = new TreeNode(root);
        for(i = 0; i < inorder.length; i++) {
            if(inorder[i] == root) break;
        }
        T.left = build(in_s, i - 1,pre_s + 1, preorder, inorder);
        T.right = build(i + 1, in_end, pre_s + i - in_s + 1, preorder, inorder);
        return T;
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
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder));
    }
}
