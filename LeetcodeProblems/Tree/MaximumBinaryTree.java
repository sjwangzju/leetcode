package Tree;

/**
 * Created by sjwang on 07/26/2018.
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0 || nums == null) return null;
        return construct(nums, 0, nums.length - 1);
    }
    public TreeNode construct(int[] nums, int lo, int hi) {
        TreeNode N = null;
        int m = lo;
        for(int i = lo; i <= hi; i++){
            m = nums[i] > nums[m] ? i : m;
        }
        if(lo <= hi){
            N = new TreeNode(nums[m]);
            N.left = construct(nums, lo, m - 1);
            N.right = construct(nums, m + 1, hi);
        }
        return N;
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
        int[] nums = {3,2,1,6,0,5};
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(nums));
    }
}
