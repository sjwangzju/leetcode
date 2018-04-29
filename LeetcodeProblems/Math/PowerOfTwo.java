package Math;

/**
 * Created by sjwang on 29/04/2018.
 * Given an integer, write a function to determine if it is a power of two.
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 2 || n == 1) return true;
        if(n < 1 || n % 2 != 0) return false;
        return isPowerOfTwo(n >> 1);
    }

    public static void main(String args[]){
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
    }
}
