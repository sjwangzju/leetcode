package Intuit;

import java.util.*;

public class ConfigurationValues {


    public void getValues(String[] input) {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String s: input) {
            String[] strs = s.split("\n");
            strs[0] = strs[0].substring(1, strs[0].length() - 1);
            String s1 = strs[0];

            if (strs[0].contains(":")) {
                s1 = strs[0].split(":")[0];
                String s2 = strs[0].split(":")[1];
                if (!adj.containsKey(s2)) {
                    adj.put(s2, new LinkedList<>());
                }
                adj.get(s2).add(s1);
                indegree.put(s1, indegree.getOrDefault(s1, 0) + 1);
            }
            if (!indegree.containsKey(s1)) indegree.put(s1, 0);
            map.put(s1, new HashMap<>());

            for (int i = 1; i < strs.length; i++) {
                strs[i].replace(" ","");
                map.get(s1).put(strs[i].split("=")[0], strs[i].split("=")[1]);
            }
        }

        PriorityQueue<String> q = new PriorityQueue<>();

        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                q.add(s);
            }
        }

        List<String> res = new LinkedList<>();
        while (!q.isEmpty()) {
            String tmp = q.poll();
            res.add(tmp);
            Map<String, String> map1 = map.get(tmp);

            if (adj.containsKey(tmp)) {
                List<String> neigh = adj.get(tmp);
                for (String n: neigh) {

                    Map<String, String> map2 = map.get(n);

                    for (String s: map1.keySet()) {
                        if (!map2.containsKey(s)) {
                            map2.put(s, map1.get(s));
                        }
                    }

                    indegree.put(n, indegree.get(n) - 1);
                    if (indegree.get(n) == 0) {
                        q.offer(n);
                    }
                }
            }
        }

        Collections.sort(res, (a,b) -> (a.compareTo(b)));

        for (String s: res) {
            System.out.println("[" + s + "]");
            Map<String, String> m = map.get(s);
            List<String> key = new ArrayList<>(m.keySet());
            Collections.sort(key);

            for (String str: key) {
                System.out.println(str + " = " + m.get(str));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        String[] input = {"[base_server]\nram = 16G\ndisk = 15G", "[review_console:admin_console]",
//                "[admin_console:base_server]\nram = 32G\nowner = root"};
        String[] input = {"[staging_server:base_server]\nram = 8G\nenvname = Staging",
                "[dev_server:staging_server]\nenvname = Dev", "[test_server:dev_server]\ndisk = 4G",
                "[base_server]\nram = 16G\ndisk = 15G", "[qa_server:base_server]\nram = 4G"};
        new ConfigurationValues().getValues(input);
    }
}
