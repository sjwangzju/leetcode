package FullTime.Facebook;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    // Return the exclusive time of each function, sorted by their function id.
    //
    // Input:
    // n = 2
    // logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    // Output: [3, 4]
    //
    // Thoughts:
    // 1. stack - store the id
    //
    // time: O(N), space: O(N) - stack depth up to N/2
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;

        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);

            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prev;
                }
                prev = time;
                stack.push(id);
            } else {
                res[stack.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return res;
    }
}
