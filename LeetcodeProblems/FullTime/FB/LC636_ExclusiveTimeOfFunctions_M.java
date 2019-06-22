package FullTime.FB;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Stack
 *
 * time: O(N)
 * space: O(N)
 */
public class LC636_ExclusiveTimeOfFunctions_M {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if (logs == null || logs.size() == 0) return res;

        Stack<Integer> stack = new Stack<>();
        String[] str = logs.get(0).split(":");

        int prev = Integer.parseInt(str[0]);
        stack.push(prev);

        for (int i = 1; i < logs.size(); i++) {
            String[] curLog = logs.get(i).split(":");
            int id = Integer.parseInt(curLog[0]);
            int val = Integer.parseInt(curLog[2]);

            if (curLog[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += val - prev;
                }
                prev = val;
                stack.push(id);
            } else {
                res[id] += val - prev + 1;
                stack.pop();
                prev = val + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","0:end:6");
        int[] res = new LC636_ExclusiveTimeOfFunctions_M().exclusiveTime(n, logs);

        for (int i: res) {
            System.out.println(i);
        }
    }
}
