package FB;

public class RearrangePositiveAndNegativeNumbers {

    /**
     * Can't use extra space
     * time: O(N^2), space: O(1)
     * @param nums
     */
    public void rearrange(int[] nums) {
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = nums[i];
                move(nums, neg, i - 1);
                nums[neg] = tmp;
                neg++;
            }
        }
        return;
    }

    public void move(int[] nums, int start, int end) {
        for (int i = end; i >= start; i--) {
            nums[i + 1] = nums[i];
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {12,11,-13,-5,6,-7,5,-3,-6};
        new RearrangePositiveAndNegativeNumbers().rearrange(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
