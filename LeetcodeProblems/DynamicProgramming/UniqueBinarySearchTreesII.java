package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 08/08/2018.
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generate(1, n);
    }
    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> L = new ArrayList<>();
        if(start > end) {
            L.add(null);
            return L;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    L.add(cur);
                }
            }
        }
        return L;
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
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3));
    }
}
