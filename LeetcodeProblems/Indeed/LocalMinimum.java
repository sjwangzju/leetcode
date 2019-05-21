package Indeed;

public class LocalMinimum {

    /**
     * linear search
     *
     * time: O(N), space: O(1)
     *
     * @param nums
     * @return
     */
    public int findLocalMinI(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * binary search
     *
     * time: O(logN), space: O(1)
     *
     * @param nums
     * @return
     */
    public int findLocalMinII(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        int[] nums = {8,5,3,6,1,4,7};
        System.out.println(new LocalMinimum().findLocalMinII(nums));
    }
}
