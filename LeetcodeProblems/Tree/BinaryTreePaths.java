package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 07/27/2018.
 *
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    List<String> L = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return L;
        findPaths(root, "");
        return L;
    }
    public void findPaths(TreeNode root, String str) {
        if(root.left == null && root.right == null) {
            L.add(str + root.val);
        }
        if(root.left != null) findPaths(root.left, str + root.val + "->");
        if(root.right != null) findPaths(root.right, str + root.val + "->");
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
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.right = t31;
        System.out.println(new BinaryTreePaths().binaryTreePaths(t1));
    }
}
