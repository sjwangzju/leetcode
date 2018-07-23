package Array;

/**
 * Created by sjwang on 07/23/2018.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null) return;
        int firstSmall = -1, secondSmall = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]) {
                firstSmall = i - 1; break;
            }
        }
        if(firstSmall == -1){
            ReverseNum(nums, 0, nums.length - 1);
        }
        else{
            for(int i = nums.length - 1; i > firstSmall; i--){
                if(nums[i] > nums[firstSmall]) {
                    secondSmall = i; break;
                }
            }
            swap(nums, firstSmall, secondSmall);
            ReverseNum(nums, firstSmall + 1, nums.length - 1);
        }
        return;
    }
    public void ReverseNum(int[] nums, int start, int end){
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String args[]){
        int[] nums = {1,2,7,4,3,1};
        new NextPermutation().nextPermutation(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
