package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sjwang on 07/27/2018.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> L = new ArrayList<>();
        if(root == null) return L;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            int size = Q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = Q.poll();
                if(cur.left != null) Q.offer(cur.left);
                if(cur.right != null) Q.offer(cur.right);
                l.add(cur.val);
            }
            L.add(l);
        }
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
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(7);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(t1));
    }
}
