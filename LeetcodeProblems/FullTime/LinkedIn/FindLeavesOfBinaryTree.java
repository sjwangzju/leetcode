package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, collect a tree's nodes as if you were doing this:
    // Collect and remove all leaves, repeat until the tree is empty.
    //
    // Input: [1,2,3,4,5]
    //
    //          1
    //         / \
    //        2   3
    //       / \
    //      4   5
    //
    // Output: [[4,5,3],[2],[1]]
    //
    // Thoughts:
    // 1. DFS - get the height from leaves
    // 2. post-order
    //
    // time: O(N), space: O(N)
    //
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return res;
        getHeight(root);
        return res;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return -1;

        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }
}
