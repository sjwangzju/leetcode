package FullTime.FB;

/**
 * DP
 *
 * stp1: get sum of window size k
 * stp2: get max sum index from left
 * stp3: get max sum index from right
 * stp4: iterate middle
 *
 * time: O(N)
 * space: O(N)
 */
public class LC689_MaximumSumOf3NonOverlappingSubarrays_H {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sumofk = new int[len - k + 1];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                sumofk[i-k+1] = sum;
            }
        }

        int[] left = new int[sumofk.length];
        int[] right = new int[sumofk.length];

        int maxIndex = 0;
        for (int i = 0; i < sumofk.length; i++) {
            if (sumofk[i] > sumofk[maxIndex]) {
                maxIndex = i;
            }
            left[i] = maxIndex;
        }

        maxIndex = sumofk.length - 1;
        for (int i = maxIndex; i >= 0; i--) {
            if (sumofk[i] >= sumofk[maxIndex]) {
                maxIndex = i;
            }
            right[i] = maxIndex;
        }

        int[] res = new int[]{0, k, 2*k};
        for (int n = k; n < sumofk.length - k; n++) {
            int m = left[n - k], l = right[n + k];
            if (sumofk[m] + sumofk[n] + sumofk[l] >
                    sumofk[res[0]] + sumofk[res[1]] + sumofk[res[2]]) {
                res[0] = m;
                res[1] = n;
                res[2] = l;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int[] res = new LC689_MaximumSumOf3NonOverlappingSubarrays_H().maxSumOfThreeSubarrays(nums, 2);
        for (int n: res) {
            System.out.print(n + " ");
        }
    }
}
