package FullTime.Facebook;

import java.util.Random;

public class ReservoirSampling {

    // Case 1: For last n-k stream items, i.e., for stream[i] where k <= i < n
    // Probability that the item is picked = [k/(k+1)] x [(k+1)/(k+2)] x [(k+2)/(k+3)] x … x [(n-1)/n] = k/n
    //
    // Case 2: For first k stream items, i.e., for stream[i] where 0 <= i < k
    // Probability that the item is not picked when items stream[k], stream[k+1], …. stream[n-1]
    // are considered = [k/(k+1)] x [(k+1)/(k+2)] x [(k+2)/(k+3)] x … x [(n-1)/n] = k/n
    //
    // randomly select k items from nums
    //
    // time: O(N), space: O(k)
    public int[] select(int[] nums, int k) {
        int[] res = new int[k];
        // initialize res with first k elements in nums
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }

        Random rd = new Random();
        for (int i = k; i < nums.length; i++) {
            int tmp = rd.nextInt(i + 1);
            if (tmp < k) {
                res[tmp] = nums[i];
            }
        }
        return res;
    }
}
