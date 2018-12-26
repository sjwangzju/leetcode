package Airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WiggleSortII {

    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        shuffle(a);
        return findKth(a, 0, n - 1, n - k);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public void shuffle(int[] nums) {
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = rd.nextInt(i + 1);
            swap(nums, i, j);
        }
    }

    /**
     * find the kth (k>=0) smallest element in nums[]
     * @param nums
     * @param low
     * @param high
     * @param k
     * @return
     *
     *
     * pivot = 3
     *
     *  3   2   1   5   6   4
     * lb  pt              hb
     *
     * 2   3    1   5   6   4
     *     lb   pt         hb
     *
     * 2   1    3   5   6   4
     *         lb   pt     hb
     *
     * 2   1    3   4   6   5
     *         lb   pt  hb
     *
     * 2   1    3   6   4   5
     *         lb   pt
     *         hb
     *
     *
     *
     */
    private int findKth(int[] nums, int low, int high, int k) {
        if (low > high) return Integer.MIN_VALUE;
        int pivot = nums[low];
        int lb = low, hb = high, pt = low+1;
        while(pt <= hb) {
            if(nums[pt] < pivot) swap(nums, lb++, pt++);
            else if(nums[pt] > pivot) swap(nums, pt, hb--);
            else pt++;
        }
        if(k < lb) return findKth(nums, low, lb-1, k);
        else if(k > hb) return findKth(nums, hb+1, high, k);
        else return pivot;
    }

//    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        System.out.println(new WiggleSortII().quickSelect(nums, 0, nums.length - 1, 4));
//    }


    /**
     * lc324 - Wiggle SortII
     *
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        shuffle(nums);
        int len = nums.length;
        int leftLen = 0;
        int rightLen = 0;
        double median = 0;

        leftLen = len % 2 == 1 ? len / 2 + 1: len / 2;
        rightLen = len - leftLen;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (len % 2 == 1) {
            median = findKth(nums, 0, nums.length-1, len/2);
        } else {
            median = (findKth(nums, 0, nums.length - 1, len / 2)
                    + findKth(nums, 0, nums.length - 1, len / 2 - 1)) / 2.0;
        }

        for (int n: nums) {
            if (n < median) {
                left.add(n);
            } else if (n > median){
                right.add(n);
            }
        }

        while (left.size() < leftLen) {
            left.add((int)median);
        }

        while (right.size() < rightLen) {
            right.add((int)median);
        }

        for (int i = 0; i < leftLen; i++) {
            nums[2 * i] = left.get(leftLen - 1 - i);
        }

        for (int i = 0; i < rightLen; i++) {
            nums[2 * i + 1] = right.get(i);
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new WiggleSortII().wiggleSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
//        System.out.print(new WiggleSortII().findKthLargest(nums, 2));
    }

}
