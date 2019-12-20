package FullTime.OCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, return all duplicate subtrees.
    // For each kind of duplicate subtrees, you only need to return the root node of any one of them.
    // Two trees are duplicate if they have the same structure with same node values.
    //
    // post-order traversal
    // time: O(N^2), space: O(N)
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        s.append(dfs(root.left)).append(" ").append(root.val).append(dfs(root.right)).append(" ");

        map.put(s.toString(), map.getOrDefault(s.toString(), 0) + 1);
        if (map.get(s.toString()) == 2) res.add(root);
        return s.toString();
    }
}
