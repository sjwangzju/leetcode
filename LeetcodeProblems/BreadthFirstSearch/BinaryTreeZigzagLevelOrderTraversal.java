package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> L = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int curN = 1, nextN = 0;
        boolean flag = false;
        List<Integer> l = new ArrayList<>();
        while(!Q.isEmpty()) {
            TreeNode cur = Q.poll();
            curN--;
            if(cur.right != null) {
                Q.offer(cur.right);
                nextN++;
            }
            if(cur.left != null) {
                Q.offer(cur.left);
                nextN++;
            }
            if(flag) l.add(cur.val);
            else l.add(0, cur.val);
            if(curN == 0) {
                curN = nextN;
                nextN = 0;
                flag = !flag;
                L.add(l);
                l = new ArrayList<>();
            }
        }
        return L;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(7);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(t1));
    }
}
