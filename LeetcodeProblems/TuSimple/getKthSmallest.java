package TuSimple;

import java.util.PriorityQueue;

public class getKthSmallest {

    /**
     * keep a pq of size k
     * time: O(nlogn), space: O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int kthSmall(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));

        for (int n: nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        System.out.println(new getKthSmallest().kthSmall(nums, 1));
    }
}
