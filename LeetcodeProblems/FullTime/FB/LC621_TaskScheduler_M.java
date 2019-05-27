package FullTime.FB;

import java.util.*;

/**
 * max heap - task num in descending order
 * start over when reach cooling time
 *
 * time: O(N), N is num of total intervals
 * space: O(1)
 */
public class LC621_TaskScheduler_M {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // task num in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        for (char task: map.keySet()) {
            pq.offer(map.get(task));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int curInterval = 0;
            List<Integer> tmp = new LinkedList<>();

            // iterate through tasks in the pq until reach the cooling interval
            // if pq is empty -> idle
            while (curInterval <= n) {
                if (!pq.isEmpty()) {
                    int top = pq.poll();
                    if (top > 1) tmp.add(top - 1);
                }
                sum++;
                curInterval++;
                if (pq.isEmpty() && tmp.size() == 0) {
                    break;
                }
            }

            // add all remaining tasks back into the pq
            for (int num: tmp) {
                pq.offer(num);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(new LC621_TaskScheduler_M().leastInterval(tasks, 2));
    }
}
