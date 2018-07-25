package Tree;

import java.util.Stack;

/**
 * Created by sjwang on 07/25/2018.
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
    public static class BSTIterator {
        Stack<TreeNode> stack =  null ;
        TreeNode cur = null ;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(stack.isEmpty() && cur == null) return false;
            return true;
        }

        /** @return the next smallest number */
        public int next() {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode N = stack.pop();
            cur = N.right;
            return N.val;
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(4);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(5);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        BSTIterator i = new BSTIterator(t1);
        System.out.println(i.next());
    }
}
