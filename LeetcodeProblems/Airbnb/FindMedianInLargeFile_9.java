package Airbnb;


public class FindMedianInLargeFile_9 {

    /**
     * binary search, time: O(logN) -> Max recursive time: 32
     * @param nums
     * @param k
     * @param min
     * @param max
     * @return
     */
    public long binarySearch(int[] nums, int k, long min, long max) {
        if (min >= max) {
            return min;
        }
        long mid = min + (max - min) / 2;
        int cnt = 0;
        long res = min;
        for (int n: nums) {
            if (n <= mid) {
                cnt++;
                res = Math.max(res, n);
            }
        }
        if (cnt == k) return res;
        if (cnt < k) return binarySearch(nums, k, mid + 1, max);
        return binarySearch(nums, k, min, res);
    }

    public double findMedian(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return (double) binarySearch(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return (double) (binarySearch(nums, n / 2, Integer.MIN_VALUE, Integer.MAX_VALUE)
                + binarySearch(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2.0;
    }

    public static void main (String[] args) {
        int[] nums = {2,2,2};
        System.out.println(new FindMedianInLargeFile_9().findMedian(nums));
    }
}
