package FullTime.FB;

import java.util.PriorityQueue;

/**
 * Two Priority Queue
 *
 * time: O(nlogk)
 * space: O(k)
 */
public class LC480_SlidingWindowMedian_H {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        pq1 = new PriorityQueue<>((a,b) -> (b.compareTo(a)));
        pq2 = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        res[0] = getMedian();

        for (int i = 1; i <= nums.length - k; i++) {
            if (pq1.contains(nums[i - 1])) {
                pq1.remove(nums[i - 1]);
            } else {
                pq2.remove(nums[i - 1]);
            }
            update();
            addNum(nums[i + k - 1]);
            res[i] = getMedian();
        }
        return res;
    }

    // O(1)
    public double getMedian() {
        int s1 = pq1.size(), s2 = pq2.size();
        if (s1 == s2) {
            return ((double) pq1.peek() + (double) pq2.peek()) / 2.0;
        }
        if (s1 > s2) return pq1.peek();
        return pq2.peek();
    }

    // O(logK)
    public void addNum(int n) {
        if (pq1.size() == 0 || n <= pq1.peek()) {
            pq1.offer(n);
        } else {
            pq2.offer(n);
        }
        update();
    }

    // O(1)
    public void update() {
        if (pq1.size() - pq2.size() > 1) {
            pq2.offer(pq1.poll());
        }
        if (pq2.size() - pq1.size() > 1) {
            pq1.offer(pq2.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3};
        int k = 4;
        double[] res = new LC480_SlidingWindowMedian_H().medianSlidingWindow(nums, k);

        for (double d: res) {
            System.out.println(d);
        }
    }
}
