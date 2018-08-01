package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<Integer> L = new ArrayList<>();
        int curN = 1, nextN = 0;
        while(!Q.isEmpty()) {
            TreeNode t = Q.poll();
            curN--;
            int temp = t.val;
            if(t.left != null) {
                Q.offer(t.left);
                nextN++;
            }
            if(t.right != null) {
                Q.offer(t.right);
                nextN++;
            }
            if(curN == 0) {
                L.add(temp);
                curN = nextN;
                nextN = 0;
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(5);
        TreeNode t32 = new TreeNode(4);
        TreeNode t41 = new TreeNode(6);
        t1.left = t21; t1.right = t22;
        t21.right = t31; t22.right = t32;
        t31.left = t41;
        System.out.println(new BinaryTreeRightSideView().rightSideView(t1));
    }
}
