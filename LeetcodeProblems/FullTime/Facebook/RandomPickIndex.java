package FullTime.Facebook;

import java.util.Random;

public class RandomPickIndex {

    // Reservoir Sampling
    //
    // {1,2,3,3,3}
    // index 2: 1*1/2*2/3 = 1/3
    // index 3: 1/2*2/3 = 1/3
    // index 4: 1/3
    // P = P(picked) * (1 - P(replaced))
    //
    // time: O(N), space: O(N)
    class Solution {

        int[] nums;
        Random rd;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rd = new Random();
        }

        public int pick(int target) {
            int res = -1, cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) continue;
                cnt++;
                if (rd.nextInt(cnt) == 0) {
                    res = i;
                }
            }
            return res;
        }
    }
}
