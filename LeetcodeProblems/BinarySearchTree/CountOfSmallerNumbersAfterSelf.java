package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 09/03/2018.
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> L = new ArrayList<>(nums.length);
        L.addAll(Arrays.asList(0));
        TreeNode N = new TreeNode(0);
        for(int i = 1; i < nums.length; i++) {
            L = addToTree(N, nums, i, L);
        }
        return L;
    }
    public List<Integer> addToTree(TreeNode root, int[] nums, int index, List<Integer> L) {
        if(nums[index] < nums[root.val]) {
            L.set(root.val, L.get(root.val) + 1);
            if(root.left == null) root.left = new TreeNode(index);
            else addToTree(root.left, nums, index, L);
        }
        else {
            if(root.right == null) root.right = new TreeNode(index);
            else addToTree(root.right, nums, index, L);
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
        int[] nums = {5,2,6,1};
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
    }
}
