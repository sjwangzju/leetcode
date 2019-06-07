package FullTime.FB;

import java.util.PriorityQueue;
import java.util.Random;

public class LC215_KthLargestElementInAnArray_M {

    // min heap of size k
    // time: O(klogN)
    // space: O(k)
    public int findKthLargestI(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n: nums) {
            if (pq.size() < k) {
                pq.offer(n);
            } else {
                if (n > pq.peek()) {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
    }


    // quick select
    // time: avg - O(N), worst - O(N2)
    // space: O(1)
    public int findKthLargestII(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, len - k);
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo == hi) return nums[lo];

        Random random = new Random();
        int pivotIndex = lo + random.nextInt(hi - lo);
        int curPivot = partition(nums, lo, hi, pivotIndex);

        if (curPivot == k) return nums[curPivot];
        if (curPivot > k) return quickSelect(nums, lo, curPivot - 1, k);
        return quickSelect(nums, curPivot + 1, hi, k);
    }

    public int partition(int[] nums, int lo, int hi, int pivotIndex) {
        int pos = lo;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, hi);

        for (int i = lo; i <= hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pos);
                pos++;
            }
        }
        swap(nums, pos, hi);
        return pos;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(new LC215_KthLargestElementInAnArray_M().findKthLargestII(nums, 2));
    }
}
