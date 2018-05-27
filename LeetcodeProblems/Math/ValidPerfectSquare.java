package Math;

/**
 * Created by sjwang on 05/15/2018.
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Returns: True
 * Example 2:
 *
 * Input: 14
 * Returns: False
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String args[]) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(2147483647));
    }
}
