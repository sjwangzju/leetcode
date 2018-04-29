package Math;

/**
 * Created by sjwang on 29/04/2018.
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 *
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range.
 */

public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 1) return true;
        if(num == 0) return false;
        while(num % 2 == 0) num >>= 1;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static void main(String args[]){
        System.out.println(new UglyNumber().isUgly(8));
    }
}
