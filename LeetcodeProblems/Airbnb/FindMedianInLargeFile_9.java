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
    public double binarySearch(int[] nums, int k, double min, double max) {
        if (min >= max) {
            return min;
        }
        double mid = min + (max - min) / 2.0;
        int cnt = 0;
        double res = min;
        for (int n: nums) {
            if (n <= mid) {
                cnt++;
                res = Math.max(res, n);
            }
        }
        if (cnt == k) {
            return res;
        } else if (cnt < k) {
            return binarySearch(nums, k, mid, max);
        } else {
            return binarySearch(nums, k, min, mid);
        }
    }

    public double findMedian(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return binarySearch(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return (binarySearch(nums, n / 2, Integer.MIN_VALUE, Integer.MAX_VALUE)
                + binarySearch(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2.0;
    }

    public static void main (String[] args) {
        int[] nums = {1,2};
        System.out.println(new FindMedianInLargeFile_9().findMedian(nums));
    }
}
