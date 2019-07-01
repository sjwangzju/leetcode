package FullTime.FB;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet
 *
 * time: O(N)
 * space: O(N)
 */
public class LC128_LongestConsecutiveSequence_H {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        int max = 1;
        for (int n: nums) {
            if (!set.contains(n - 1)) {
                int curN = n;
                int curL = 1;
                while (set.contains(curN + 1)) {
                    curL++;
                    curN++;
                }
                max = Math.max(max, curL);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,8,5,7,6};
        System.out.println(new LC128_LongestConsecutiveSequence_H().longestConsecutive(nums));
    }
}
