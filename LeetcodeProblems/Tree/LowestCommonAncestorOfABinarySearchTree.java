package Tree;

/**
 * Created by sjwang on 07/26/2018.
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
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
        System.out.println(new LowestCommonAncestorOfABinarySearchTree().lowestCommonAncestor(t1, t21, t22));
    }
}
