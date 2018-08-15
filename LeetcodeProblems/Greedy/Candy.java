package Greedy;

import java.util.Arrays;

/**
 * Created by sjwang on 08/14/2018.
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Example 1:
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *              The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        for(int i = 1 ; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        int sum = candys[ratings.length - 1];
        for(int i = ratings.length - 2 ; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]) {
                candys[i] = candys[i + 1] + 1;
            }
            sum += candys[i];
        }
        return sum;
    }

    public static void main(String args[]){
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(new Candy().candy(ratings));
    }
}
