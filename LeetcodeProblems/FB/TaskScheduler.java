package FB;

import java.util.*;

public class TaskScheduler {

    /**
     * Tasks should be in order
     * time: O(N), space: O(M), M is the number of unique tasks
     * @param tasks
     * @param cooldown
     * @return
     */
    public int intervalsI(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<>();
        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            int curTask = tasks[i];
            if (!map.containsKey(curTask)) {
                time += 1;
            } else {
                int last = map.get(curTask);
                int gap = time - last - 1;
                time += gap < cooldown ? cooldown - gap : 1;
            }
            map.put(curTask, time);
        }
        return time;
    }

    public static class task {
        int number;
        int type;
        task(int num, int t) {
            this.number = num;
            this.type = t;
        }
    }

    /**
     * can change the order of tasks
     * time: O(N), N is the number of tasks, space: O(M), M is the number of unique tasks
     *
     * @param tasks
     * @param cooldown
     * @return
     */
    public int intervalsII(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: tasks) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<task> pq = new PriorityQueue<>((task1, task2) -> (task2.number - task1.number));
        for (int n: map.keySet()) {
            task t = new task(map.get(n), n);
            pq.offer(t);
        }

        int intervals = 0;
        List<task> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cnt = 0;
            for (task t: pq) {
                intervals++;
                cnt++;
                list.add(t);
                if (cnt - 1 == cooldown) {
                    break;
                }
            }
            for (task t: list) {
                pq.remove(t);
                t.number -= 1;
                if (t.number != 0) {
                    pq.offer(t);
                }
            }
            if (pq.isEmpty()) break;
            list.clear();
            intervals += Math.max(0, cooldown - cnt + 1);
        }
        return intervals;
    }

    public static void main(String[] args) {
        int[] taks = {1,1,1,1,2,2,2,3,3,4,4,5,5,6};
        int cooldown = 2;
        System.out.println(new TaskScheduler().intervalsII(taks, cooldown));
    }
}
