package Array;

/**
 * Created by sjwang on 05/15/2018.
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
 * you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 *
 * Example 1:
 * Input: [1,4], 2
 * Output: 4
 * Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 * This poisoned status will last 2 seconds until the end of time point 2.
 * And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 * So you finally need to output 4.
 *
 * Note:
 * You may assume the length of given time series array won't exceed 10000.
 * You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int sum = 0;
        for(int i = 1; i < timeSeries.length; i ++){
            if(timeSeries[i] - timeSeries[i - 1] >= duration) sum += duration;
            else sum += timeSeries[i] - timeSeries[i - 1];
        }
        return sum + duration;
    }

    public static void main(String args[]){
        int[] nums = {1,2};
        System.out.println(new TeemoAttacking().findPoisonedDuration(nums, 2));
    }
}
