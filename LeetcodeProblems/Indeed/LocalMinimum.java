package Indeed;

public class LocalMinimum {

    /**
     * binary search - time: O(logN)
     * @param nums
     * @return
     */
    public int findLocalMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {8,5,3,6,1,4,7};
        System.out.println(new LocalMinimum().findLocalMin(nums));
    }
}
