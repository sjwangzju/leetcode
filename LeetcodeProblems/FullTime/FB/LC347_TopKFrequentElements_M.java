package FullTime.FB;

import java.util.*;

/**
 * time: O(NlogK)
 * space: O(K)
 */
public class LC347_TopKFrequentElements_M {

    // pq
    // time: O(NlogK)
    // space: O(K)
    public List<Integer> topKFrequentI(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (map.get(a) - map.get(b)));

        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }

        for (int n: map.keySet()) {
            if (q.size() < k) {
                q.offer(n);
            } else {
                if (map.get(n) > map.get(q.peek())) {
                    q.poll();
                    q.offer(n);
                }
            }
        }
        for (int n: q) {
            res.add(0, n);
        }
        return res;
    }

    // bucket sort
    // time: O(N)
    // space: O(N)
    public List<Integer> topKFrequentII(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }

        List[] bucket = new LinkedList[nums.length + 1];
        for (int n: map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList();
            }
            bucket[freq].add(n);
        }
        for (int i = bucket.length - 1; i >= 1; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
            if (res.size() >= k) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> res = new LC347_TopKFrequentElements_M().topKFrequentII(nums, 2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
