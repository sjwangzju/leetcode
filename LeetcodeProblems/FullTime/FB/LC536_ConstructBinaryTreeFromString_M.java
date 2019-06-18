package FullTime.FB;

import java.util.Stack;

/**
 * Solution1: stack
 *
 * time: O(N)
 * space: O(N)
 */
public class LC536_ConstructBinaryTreeFromString_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // stack
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;

        TreeNode root = null;
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '-' || Character.isDigit(cur)) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(cur);

                while (i + 1 < s.length() && (s.charAt(i + 1) == '-' || Character.isDigit(s.charAt(i + 1)))) {
                    tmp.append(s.charAt(i + 1));
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(tmp.toString()));

                if (root != null) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }
                stack.push(node);
            }
            else if (cur == '(') {
                root = stack.peek();
            }
            else {
                stack.pop();
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode node =new LC536_ConstructBinaryTreeFromString_M().str2tree(s);
        System.out.println(node.val);
    }
}
