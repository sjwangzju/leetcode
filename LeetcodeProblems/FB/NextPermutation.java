package FB;

public class NextPermutation {

    /**
     * step 1: 1 3 7 5 4 1  -> find the last nums[i] < nums[i + 1], nums[i] called small
     *           ^
     *
     * step 2: 1 3 7 5 4 1  -> find the second smallest
     *           ^     ^
     *
     * step 3: 1 4 [7 5 3 1]  -> swap small and second small
     *           ^      ^
     *
     * step 4: 1 4 1 3 5 7 -> inverse the substring -> done
     *             ^ ^ ^ ^
     *
     * time: O(N), space: O(1)
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        int small = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                small = i; break;
            }
        }
        if (small == -1) {
            inverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > small; i--) {
            if (nums[i] > nums[small]) {
                int tmp = nums[i];
                nums[i] = nums[small];
                nums[small] = tmp;
                break;
            }
        }
        inverse(nums, small + 1, nums.length - 1);
        return;
    }

    public void inverse(int[] nums, int start, int end) {
        int len = end - start + 1;
        for (int i = 0; i < len / 2; i++) {
            int tmp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = tmp;
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,5,4,1};
        new NextPermutation().nextPermutation(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
