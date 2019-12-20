package FullTime.Facebook;

import java.util.*;

public class TaskScheduler {

    /**
     * Task scheduling with cooling interval (among different tasks)
     * Tasks can be done in any order. Only need to minimize total intervals.
     *
     * e.g.
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     *
     * Thoughts:
     * 1. Greedy Algorithm (do the tasks in frequency descending order)
     * 2. use pq to sort the freq of tasks
     * 3. pick the tasks in the order of descending freq
     * 4. loop until a cycle of cooling time n is finished
     *
     * time: O(n*N), n is cooling interval, N is total num of tasks
     * space: O(k), k is num of unique tasks
     *
     */
    public int leastIntervalI(char[] tasks, int n) {
        int[] cnt = new int[26];
        PriorityQueue<Character> pq
                = new PriorityQueue<>((a,b) -> (cnt[b-'A']-cnt[a-'A']));
        for (char task: tasks) {
            if (cnt[task - 'A'] == 0) pq.offer(task);
            cnt[task - 'A']++;
        }

        int res = 0;
        while (!pq.isEmpty()) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    Character c = pq.poll();
                    cnt[c - 'A']--;
                    if (cnt[c - 'A'] > 0) list.add(c);
                }
                res++;
                // all tasks finished, break immediately to avoid unnecessary intervals
                if (pq.isEmpty() && list.size() == 0) break;
            }
            for (Character c: list) {
                pq.offer(c);
            }
        }
        return res;
    }


    /**
     * Task scheduling with cooling interval (only for the same task)
     * Tasks must be done in fixed order
     *
     * e.g.
     * Input: tasks = ["A","A","B","C","A","C","D], n = 2
     * Output: 10
     * Explanation: A -> idle -> idle -> A -> B -> C -> A -> idle -> C -> D.
     *
     * Thoughts:
     * 1. use HashMap to record the prev time of each task
     *
     * time: O(N)
     * space: O(k), k is num of unique tasks
     */
    public int leastIntervalII(char[] tasks, int n) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char t : tasks) {
            if (!map.containsKey(t)) {
                res += 1;
            } else {
                res = Math.max(map.get(t) + n + 1, res + 1);
            }
            map.put(t, res);
        }
        return res;
    }


    /**
     * Follow-up: if cooling interval is << num of unique tasks
     *
     * Thoughts:
     * 1. we should reduce the space complexity
     * 2. maintain a queue with size of cool-down
     * 3. keep removing old tasks from the queue and map
     *
     * time: O(N), space: O(n), n is cool-down time
     */
    public int leastIntervalIII(char[] tasks, int n) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (char t : tasks) {
            if (!map.containsKey(t)) {
                res += 1;
            } else {
                res = Math.max(map.get(t) + n + 1, res + 1);
            }
            // remove old tasks from the queue and map to release space
            while (!q.isEmpty() && map.get(q.peek()) < res - n) {
                map.remove(q.poll());
            }
            q.offer(t);
            map.put(t, res);
        }
        return res;
    }


    public static void main(String[] args) {
//        char[] tasks = {'A','A','B','C','A','C','D'};
        char[] tasks = {'A','A','B','A'};
        System.out.println(new TaskScheduler().leastIntervalIII(tasks, 2));
    }
}
