package BinarySearchTree;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by sjwang on 09/03/2018.
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between
 * nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        TreeSet<Long> tree = new TreeSet<>();
        tree.add((long)nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i > k) {
                tree.remove((long) nums[i - k - 1]);
            }
            long left = (long) nums[i] - t;
            long right = (long) nums[i] + t;
            if (left <= right && !tree.subSet(left, right + 1).isEmpty()) {
                return true;
            }
            tree.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String args[]){
        int[] nums = {1,5,9,1,5,9};
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
