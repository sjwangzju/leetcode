package FullTime.FB;

import java.util.PriorityQueue;

/**
 * max heap of size K
 * time: O(NlogK)
 * space: O(K)
 */
public class LC973_KClosestPointsToOrigin_M {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));

        for (int[] p: points) {
            if (pq.size() < K) {
                pq.offer(p);
            } else {
                int curLen = p[0]*p[0] + p[1]*p[1];
                int[] peek = pq.peek();
                int maxLen = peek[0]*peek[0] + peek[1]*peek[1];

                if (curLen < maxLen) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{-5,4}, {-6,-5}, {4,6}};
        int K = 2;

        int[][] res = new LC973_KClosestPointsToOrigin_M().kClosest(points, K);
        for (int[] n: res) {
            System.out.println(n[0] + " " + n[1]);
        }
    }
}
