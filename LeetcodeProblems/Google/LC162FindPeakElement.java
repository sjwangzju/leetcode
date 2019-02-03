package Google;

public class LC162FindPeakElement {

    /**
     * binary search
     *
     * time: O(logN), space: O(1)
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(new LC162FindPeakElement().findPeakElement(nums));
    }
}
