package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    // You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
    // Define a pair (u,v) which consists of one element from the first array and one element from the second array.
    // Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
    //
    // Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    // Output: [[1,2],[1,4],[1,6]]
    // Explanation: The first 3 pairs are returned from the sequence:
    //             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
    //
    // pq
    // time: O(klogk), space: O(k)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));

        for (int i = 0; i < nums1.length; i++) {
            if (i == k) break;
            pq.offer(new int[]{i, 0});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (res.size() == k) break;
            if (cur[1] == nums2.length - 1) continue;
            pq.offer(new int[]{cur[0], cur[1] + 1});
        }
        return res;
    }
}
