package FullTime.FB;

import java.util.HashSet;
import java.util.Set;

/**
 * Similar to LC236 - find lowest common ancestor
 *
 * time: O(N)
 * space: O(N)
 */
public class LC865_SmallestSubtreeWithAllTheDeepestNodes_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxDepth = 0;
    int max = 0;
    Set<Integer> deepest = new HashSet<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDeepest(root, 0);
        return findLowestCommonAncestor(root);
    }

    public TreeNode findLowestCommonAncestor(TreeNode root) {
        if (root == null || deepest.contains(root.val)) return root;
        TreeNode l = findLowestCommonAncestor(root.left);
        TreeNode r = findLowestCommonAncestor(root.right);

        if (l == null && r == null) {
            return null;
        }
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }

    public void findDeepest(TreeNode root, int depth) {
        if (root == null) return;
        if (depth >= maxDepth) {
            if (depth > maxDepth) {
                maxDepth = depth;
                deepest.clear();
            }
            deepest.add(root.val);
        }
        findDeepest(root.left, depth + 1);
        findDeepest(root.right, depth + 1);
    }
}
