package Amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestTwoSum {

    public static class Container {
        public double first;
        public double second;

        public Container(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * 2 lists, find 1 number from each list
     *
     * time: O(nlogn), space: O(1)
     * @param nums1
     * @param nums2
     * @param n
     */
    public Container findClosestSumI(int[] nums1, int[] nums2, int n) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = nums2.length - 1;
        int n1 = 0;
        int n2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (l < nums1.length && r >= 0) {
            int tmp = nums1[l] + nums2[r];
            if (tmp <= n && n - tmp < min) {
                min = n - tmp;
                n1 = nums1[l];
                n2 = nums2[r];
            }
            if (tmp < n) {
                l++;
            } else {
                r--;
            }
        }
        return new Container(n1, n2);
    }

    public Container findClosestSumII(double capacity, List<Double> weights, int numOfContainers) {
        int l = 0;
        int r = weights.size() - 1;
        int resL = 0;
        int resR = 0;
        double min = Double.MAX_VALUE;

        Collections.sort(weights);

        while (l < r) {
            double tmp = weights.get(l) + weights.get(r);
            if (tmp <= capacity && capacity - tmp < min) {
                min = capacity - tmp;
                resL = l;
                resR = r;
            }
            if (tmp <= capacity) {
                l++;
            } else {
                r--;
            }
        }
        if (min == Double.MAX_VALUE) return new Container(0, 0);
        return new Container(weights.get(resL), weights.get(resR));
    }

    public static void main(String[] args) {
//        int[] nums1 = {2,3,1,5,6};
//        int[] nums2 = {6,2,12,10};
//        Container c = new ClosestTwoSum().findClosestSumI(nums1, nums2, 10);
        double capacity = 5.0;
        List<Double> weights = Arrays.asList(3.0,2.0,5.0,10.0);
        Container c = new ClosestTwoSum().findClosestSumII(capacity, weights, 4);
        System.out.println(c.first + " " + c.second);
    }
}
