package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 07/27/2018.
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {
    List<Integer> L = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return L;
        inorderTraversal(root.left);
        L.add(root.val);
        inorderTraversal(root.right);
        return L;
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        t1.right = t21;
        t21.left = t31;
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(t1));
    }
}
