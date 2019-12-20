package FullTime.Google;

import java.util.*;

public class ConfusingNumberII {

    int res = 0;
    int[] dict = {0,1,6,8,9};
    Map<Integer, Integer> map = new HashMap<>();
    public int confusingNumberII(int N) {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        backtracking(dict, 0, N);
        return res;
    }

    public boolean isConfused(long n) {
        long sum = 0, tmp = n;
        while (tmp != 0) {
            sum *= 10;
            sum += map.get((int)(tmp % 10));
            tmp /= 10;
        }
        return sum != n;
    }

    public void backtracking(int[] dict, long num, int N) {
        if (num > N) return;

        for (int i = 0; i < 5; i++) {
            if (num == 0 && i == 0) continue;
            num *= 10;
            num += dict[i];
            if (num <= N && isConfused(num)) {
                res++;
            }
            backtracking(dict, num, N);
            num /= 10;
        }
    }

    public static void main(String[] args) {
        int N = 100;
        int res = new ConfusingNumberII().confusingNumberII(N);
        System.out.println(res);
    }
}
