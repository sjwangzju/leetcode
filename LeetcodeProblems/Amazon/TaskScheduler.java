package Amazon;

import java.util.*;

public class TaskScheduler {

    /**
     * priority queue
     *
     * time: O(NlogN), space: O(N), N is the number of task types
     *
     * @param tasks
     * @param cooldown
     * @return
     */
    public int leastInterval(char[] tasks, int cooldown) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> (map.get(b) - map.get(a)));

        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (char task: map.keySet()) {
            pq.offer(task);
        }

        int interval = 0;
        while (!pq.isEmpty()) {
            int tmp = 0;
            List<Character> list = new LinkedList<>();
            for (char task: pq) {
                interval++;
                tmp++;
                list.add(task);
                if (tmp - 1 == cooldown) {
                    break;
                }
            }
            for (Character task: list) {
                pq.remove(task);
                map.put(task, map.get(task) - 1);
                if (map.get(task) != 0) {
                    pq.offer(task);
                }
            }
            if (pq.isEmpty()) break;
            interval += Math.max(cooldown - tmp + 1, 0);
        }
        return interval;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int cooldown = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, cooldown));
    }

}
