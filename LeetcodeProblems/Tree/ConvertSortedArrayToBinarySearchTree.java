package Tree;

/**
 * Created by sjwang on 07/26/2018.
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return insertNode(nums, 0, nums.length - 1);
    }
    public TreeNode insertNode(int[] nums, int lo, int hi) {
        if(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            TreeNode root  = new TreeNode(nums[mid]);
            root.left = insertNode(nums, lo, mid - 1);
            root.right = insertNode(nums, mid + 1, hi);
            return root;
        }
        return null;
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
        int[] nums = {-10, -2};
        System.out.println(new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums));
    }
}
