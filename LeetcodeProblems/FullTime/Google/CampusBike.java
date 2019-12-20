package FullTime.Google;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBike {

    class Pair {
        int w, b, d;
        Pair(int worker, int bike, int distance) {
            this.w = worker;
            this.b = bike;
            this.d = distance;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->
                (p1.d == p2.d? (p1.w == p2.w? p1.b - p2.b: p1.w - p2.w): p1.d - p2.d));

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = getDistance(workers[i][0], workers[i][1], bikes[j][0], bikes[j][1]);
                pq.offer(new Pair(i, j, dist));
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (!s1.contains(p.w) && !s2.contains(p.b)) {
                res[p.w] = p.b;
                s1.add(p.w);
                s2.add(p.b);
            }
            if (s1.size() == workers.length) break;
        }
        return res;
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


}
