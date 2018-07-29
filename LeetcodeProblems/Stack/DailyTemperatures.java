package Stack;

import java.util.Stack;

/**
 * Created by sjwang on 07/29/2018.
 *
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days
 * you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return temperatures;
        Stack<Integer> S = new Stack<>();
        int[] re = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length; i++) {
            int t = temperatures[i];
            if(S.isEmpty()) S.push(i);
            else {
                int p = S.peek();
                while(t > temperatures[p]) {
                    re[p] = i - p;
                    S.pop();
                    if(S.isEmpty()) break;
                    p = S.peek();
                }
                S.push(i);
            }
        }
        return re;
    }
    public static void main(String args[]){
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new DailyTemperatures().dailyTemperatures(temp));
    }
}
