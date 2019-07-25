package FullTime.FB;

/**
 * Two pointers
 *
 * time: O(N)
 * space: O(1)
 */
public class LC26_RemoveDuplicatesFromSortedArray_E {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new LC26_RemoveDuplicatesFromSortedArray_E().removeDuplicates(nums));
    }
}
