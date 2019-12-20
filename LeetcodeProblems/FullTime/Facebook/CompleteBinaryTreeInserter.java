package FullTime.Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
    //
    // CBTInserter(TreeNode root)
    //      initializes the data structure on a given tree with head node root;
    //
    // CBTInserter.insert(int v)
    //      insert a TreeNode into the tree with value node.val = v so that the tree remains complete,
    //      and returns the value of the parent of the inserted TreeNode;
    //
    // CBTInserter.get_root()
    //      return the head node of the tree.
    //
    class CBTInserter {

        TreeNode root;
        Queue<TreeNode> q;

        // BFS
        // time: O(N), space: O(N)
        public CBTInserter(TreeNode root) {
            this.root = root;
            this.q = new LinkedList<>();

            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode cur = q.peek();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null && cur.right != null) {
                    q.poll();
                } else {
                    break;
                }
            }
        }

        // time: O(1)
        public int insert(int v) {
            TreeNode cur = q.peek();
            TreeNode tmp = new TreeNode(v);
            if (cur.left == null) {
                cur.left = tmp;
            } else {
                cur.right = tmp;
                q.poll();
            }
            q.offer(tmp);
            return cur.val;
        }

        // time: O(1)
        public TreeNode get_root() {
            return root;
        }
    }
}
