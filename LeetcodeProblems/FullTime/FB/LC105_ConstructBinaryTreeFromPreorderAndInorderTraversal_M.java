package FullTime.FB;

/**
 * DFS (lower bound & upper bound for inorder)
 *
 * time: O(N)
 * space: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1, 0);
    }

    public TreeNode build(int[] preorder, int in_lo, int in_hi, int pre) {
        if (in_hi < in_lo || pre >= preorder.length) return null;

        TreeNode cur = new TreeNode(preorder[pre]);
        int index = map.get(preorder[pre]);
        cur.left = build(preorder, in_lo, index - 1, pre + 1);
        cur.right = build(preorder, index + 1, in_hi, pre + index - in_lo + 1);
        return cur;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal_M().buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
