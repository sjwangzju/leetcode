package String;

/**
 * Created by sjwang on 25/04/2018.
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
 * Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation.
 * 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 * and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */

public class RotatedDigits {

    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++){
            int num = i, val = i, sum = 0, mul = 1, digit = 0;
            while(num != 0){
                int d = num % 10;
                if(d == 0 || d == 1 || d == 8) digit = d;
                if(d == 2) digit = 5;
                if(d == 5) digit = 2;
                if(d == 6) digit = 9;
                if(d == 9) digit = 6;
                if(d == 3 || d == 4 || d == 7){
                    sum = val;
                    break;
                }
                sum += digit * mul;
                num /= 10;
                mul *= 10;
            }
            if(sum != val) count++;
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println(new RotatedDigits().rotatedDigits(10));
    }
}
