package Math;

/**
 * Created by sjwang on 04/28/2018.
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int minVal = findMinElement(nums), sum = 0;
        for(int i : nums){
            sum += i - minVal;
        }
        return sum;
    }
    public int findMinElement(int[] nums){
        int min = nums[0];
        for(int i : nums){
            if(i < min) min = i;
        }
        return min;
    }

    public static void main(String args[]){
        int[] nums = {1, 2, 3};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
    }
}
