package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/18/2018.
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] re = new int[nums.length - k + 1];
        for(int i = 0; i + k <= nums.length; i ++){
            if(i == 0){
                for(int j = i; j < k; j ++){
                    pq.offer(nums[j]);
                }
            }
            else{
                pq.remove(nums[i - 1]);
                pq.offer(nums[i + k - 1]);
            }
            re[i] = pq.peek();
        }
        return re;
    }
    public static void main(String args[]){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(nums, k));
    }
}
