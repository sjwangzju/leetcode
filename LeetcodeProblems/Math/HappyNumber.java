package Math;

/**
 * Created by sjwang on 28/04/2018.
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

public class HappyNumber {
    public int count = 0;
    public boolean isHappy(int n) {
        int val = squareDigits(n);
        if(val == 1) return true;
        if(val > 100){
            count ++;
            if(count > 20) return false;
        }
        return isHappy(val);
    }

    public int squareDigits(int num){
        int sum = 0;
        while(num != 0){
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(new HappyNumber().isHappy(1819140969));
    }

}
