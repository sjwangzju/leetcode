package Tree;
import java.util.List;

/**
 * Created by sjwang on 23/04/2018.
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */

public class AverageOfLevelsInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        return null;
    }

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(15);
        t1.left = null;
        t1.right = null;
        TreeNode t2 = new TreeNode(7);
        t2.left = null;
        t2.right = null;
        TreeNode t3 = new TreeNode(20);
        t3.left = t1;
        t3.right = t2;
        TreeNode t4 = new TreeNode(9);
        t4.left = null;
        t4.right = null;
        TreeNode t5 = new TreeNode(3);
        t5.left = t4;
        t5.right = t3;
    }
}
