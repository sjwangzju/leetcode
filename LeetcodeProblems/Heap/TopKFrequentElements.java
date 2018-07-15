package Heap;

import java.util.*;

/**
 * Created by sjwang on 07/15/2018.
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return null;
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> L = new ArrayList<>();
        for(int i : nums){
            if(!m.containsKey(i)) m.put(i, 1);
            else m.put(i, m.get(i) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return m.get(o2) - m.get(o1);
            }
        });
        for(int i : m.keySet()) pq.offer(i);
        while(!pq.isEmpty()){
            if(k <= 0) break;
            int n = pq.poll();
            L.add(n);
            k--;
        }
        return L;
    }
    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(new TopKFrequentElements().topKFrequent(nums, k));
    }
}
