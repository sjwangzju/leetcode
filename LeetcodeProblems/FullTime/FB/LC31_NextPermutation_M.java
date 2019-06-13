package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC31_NextPermutation_M {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // reverse starts from index i
    public void reverse(int[] nums, int i) {
        int l = i;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        new LC31_NextPermutation_M().nextPermutation(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
