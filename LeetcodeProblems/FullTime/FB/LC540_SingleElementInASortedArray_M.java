package FullTime.FB;

/**
 * time: O(logN)
 * space: O(1)
 */
public class LC540_SingleElementInASortedArray_M {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cur = nums[mid];

            if (mid - 1 >= 0 && nums[mid - 1] != cur && mid + 1 < nums.length && nums[mid + 1] != cur) {
                return cur;
            }
            if (mid % 2 == 0) {
                if (nums[mid + 1] == cur) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid - 1] == cur) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3};
        System.out.println(new LC540_SingleElementInASortedArray_M().singleNonDuplicate(nums));
    }
}
