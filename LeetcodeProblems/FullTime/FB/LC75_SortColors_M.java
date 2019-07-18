package FullTime.FB;

/**
 * swap
 *
 * time: O(N)
 * space: O(1)
 */
public class LC75_SortColors_M {

    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        int cur = 0;

        while (cur <= j) {
            if (nums[cur] == 0) {
                swap(i++, cur, nums);
                cur++;
            } else if (nums[cur] == 2) {
                swap(cur, j--, nums);
            } else {
                cur++;
            }
        }
    }

    public void swap(int m, int n, int[] nums) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,1,2,0,0};
        new LC75_SortColors_M().sortColors(nums);

        for (int n: nums) {
            System.out.print(n + " ");
        }
    }
}
