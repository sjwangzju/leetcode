package FullTime.FB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Priority Queue
 *
 * time: O(nlogk), n is the number of all elements
 * space: O(k)
 */
public class LC632_SmallestRange_H {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        int size = nums.size();
        int lo = -1, hi = -1;

        for (int i = 0; i < size; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (max - cur[0] < range) {
                range = max - cur[0];
                lo = cur[0];
                hi = max;
            }
            int lasti = cur[1];
            int lastj = cur[2];
            if (lastj == nums.get(lasti).size() - 1) {
                break;
            }
            pq.offer(new int[]{nums.get(lasti).get(lastj + 1), lasti, lastj + 1});
            max = Math.max(max, nums.get(lasti).get(lastj + 1));
        }
        return new int[]{lo, hi};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new LinkedList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        int[] res = new LC632_SmallestRange_H().smallestRange(nums);
        System.out.println(res[0] + " " + res[1]);
    }
}
