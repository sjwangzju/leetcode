package Amazon;

import java.util.*;

public class MST {

    public static class Connections {
        public String first;
        public String second;
        public int cost;

        public Connections(String t1, String t2, int c) {
            this.first = t1;
            this.second = t2;
            this.cost = c;
        }
    }

    public List<Connections> minimumCostConnection(int num, List<Connections> connection) {
        List<Connections> res = new LinkedList<>();
        Set<String> centers = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        PriorityQueue<Connections> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));

        for (Connections c: connection) {
            String s1 = c.first;
            String s2 = c.second;
            centers.add(s1);
            centers.add(s2);
            pq.offer(c);
        }

        for (String center: centers) {
            parent.put(center, center);
        }

        while (!pq.isEmpty()) {
            Connections cur = pq.poll();
            String s1 = cur.first;
            String s2 = cur.second;
            String p1 = findParent(s1, parent);
            String p2 = findParent(s2, parent);

            if (p1 != p2) {
                if (!visited.contains(s1)) {
                    visited.add(s1);
                    parent.put(s1, p2);
                } else {
                    visited.add(s2);
                    parent.put(s2, p1);
                }
                res.add(cur);
            }
            if (res.size() == centers.size() - 1) {
                return res;
            }
        }
        return new LinkedList<>();
    }

    public String findParent(String s, Map<String, String> parent) {
        while (!parent.get(s).equals(s)) {
            s = parent.get(s);
        }
        return s;
    }


    public static void main(String[] args) {
        Connections c1 = new Connections("A","B",1);
        Connections c2 = new Connections("B","C",4);
        Connections c3 = new Connections("C","E",5);
        Connections c4 = new Connections("B","E",2);
        List<Connections> list = new LinkedList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        List<Connections> res = new MST().minimumCostConnection(3, list);
        for (Connections c: res) {
            System.out.println(c.first + ", " + c.second + ", " + c.cost);
        }
    }
}
