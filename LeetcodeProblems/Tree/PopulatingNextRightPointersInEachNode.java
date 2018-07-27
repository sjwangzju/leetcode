package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjwang on 07/27/2018.
 *
 * Given a binary tree
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *
 * Example:
 * Given the following perfect binary tree,
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode cur = Q.poll();
                if(i == size - 1) cur.next = null;
                else cur.next = Q.peek();
                if(cur.left != null) {
                    Q.offer(cur.left);
                    Q.offer(cur.right);
                }
            }
        }
    }
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t21 = new TreeLinkNode(2);
        TreeLinkNode t22 = new TreeLinkNode(3);
        TreeLinkNode t31 = new TreeLinkNode(4);
        TreeLinkNode t32 = new TreeLinkNode(5);
        TreeLinkNode t33 = new TreeLinkNode(6);
        TreeLinkNode t34 = new TreeLinkNode(7);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32; t22.left = t33; t22.right = t34;
        new PopulatingNextRightPointersInEachNode().connect(t1);
    }
}
