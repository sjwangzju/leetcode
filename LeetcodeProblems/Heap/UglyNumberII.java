package Heap;

import java.util.ArrayList;

/**
 * Created by sjwang on 07/17/2018.
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note:
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> L = new ArrayList<>();
        L.add(1);
        int k = 0, m = 0, l = 0, count = 0, mini = 1;
        while(count < n - 1){
            mini = Math.min(2 * L.get(l), Math.min(3 * L.get(m), 5 * L.get(k)));
            L.add(mini);
            count++;
            if(mini == 2 * L.get(l)) l++;
            if(mini == 3 * L.get(m)) m++;
            if(mini == 5 * L.get(k)) k++;
        }
        return mini;
    }
    public static void main(String args[]){
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
}
