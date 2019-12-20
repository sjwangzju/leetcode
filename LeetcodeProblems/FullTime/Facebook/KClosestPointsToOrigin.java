package FullTime.Facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KClosestPointsToOrigin {

    // We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
    //
    //  Input: points = [[1,3],[-2,2]], K = 1
    //  Output: [[-2,2]]
    //
    // Solution1: sort array
    // time: O(NlogN), space: O(N)
    /*******************************************************************************/
    public int[][] kClosestI(int[][] points, int K) {
        Arrays.sort(points, (int[] a, int[] b)
                -> ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])));
        return Arrays.copyOfRange(points, 0, K);
    }


    // Solution2: priority queue
    // time: O(NlogK), space: O(K)
    /*******************************************************************************/
    public int[][] kClosestII(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));

        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


    // Solution3: quick sort
    // time: avg - O(N), worst - O(N^2); space: O(N)
    /*******************************************************************************/
    public int[][] kClosestIII(int[][] points, int K) {
        quickselect(points, 0, points.length - 1, K - 1);

        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickselect(int[][] points, int lo, int hi, int k) {
        if (lo == hi) return;

        Random rd = new Random();
        int pivotIndex = lo + rd.nextInt(hi - lo);
        int index = partition(points, lo, hi, pivotIndex);

        if (index > k) {
            quickselect(points, lo, index - 1, k);
        } else if (index < k) {
            quickselect(points, index + 1, hi, k);
        }
    }

    public int partition(int[][] points, int lo, int hi, int pivotIndex) {
        int[] pivot = points[pivotIndex];
        int pos = lo;

        swap(points, pivotIndex, hi);
        for (int i = lo; i <= hi; i++) {
            if (dist(points[i]) < dist(pivot)) {
                swap(points, i, pos);
                pos++;
            }
        }
        swap(points, hi, pos);
        return pos;
    }

    public int dist(int[] tmp) {
        return tmp[0] * tmp[0] + tmp[1] * tmp[1];
    }

    public void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }


}
