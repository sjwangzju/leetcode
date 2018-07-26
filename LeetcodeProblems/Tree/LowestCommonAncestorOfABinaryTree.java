package Tree;

/**
 * Created by sjwang on 07/26/2018.
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p ,q);
        if(L == null && R == null) return null;
        if(L == null) return R;
        if(R == null) return L;
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(6);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(0);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(7);
        TreeNode t34 = new TreeNode(9);
        TreeNode t41 = new TreeNode(3);
        TreeNode t42 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t22.left = t33; t22.right = t34;
        t32.left = t41; t32.right = t42;
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(t1, t31, t32).val);
    }
}
