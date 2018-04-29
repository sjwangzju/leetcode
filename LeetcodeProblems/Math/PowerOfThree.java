package Math;

/**
 * Created by sjwang on 29/04/2018.
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String args[]){
        System.out.println(new PowerOfThree().isPowerOfThree(6));
    }
}
