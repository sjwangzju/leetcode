package FullTime.LinkedIn;

import java.util.Stack;

public class DailyTemperature {

    // Given a list of daily temperatures T, return a list such that, for each day in the input,
    // tells you how many days you would have to wait until a warmer temperature.
    // If there is no future day for which this is possible, put 0 instead.
    //
    // For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
    // your output should be [1, 1, 4, 2, 1, 1, 0, 0].
    //
    // stack
    // time: O(N), space: O(N)
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}
