package FullTime.FB;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sliding Window
 *
 * time: O(N)
 * space: O(K)
 */
public class LC1004_MaxConsecutiveOnesIII_M {

    public int longestOnes(int[] A, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(-1);
        int cnt = 0, max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
                if (cnt > K) {
                    int prev = q.poll() + 1;
                    max = Math.max(max, i - prev);
                    if (prev != 0) cnt--;
                }
                q.offer(i);
            }
        }
        max = Math.max(max, A.length - 1 - q.poll());
        return max;
    }

    public static void main(String[] args) {
        int[] A = {0,0,0,1};
        int K = 3;
        System.out.println(new LC1004_MaxConsecutiveOnesIII_M().longestOnes(A, K));
    }
}
