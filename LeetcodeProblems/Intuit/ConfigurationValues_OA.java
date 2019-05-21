package Intuit;

import java.util.*;

public class ConfigurationValues_OA {


    /**
     * time: O(NlogN), N is the number of different servers
     *
     * space: O(N)
     *
     *
     *
     * input:
     *
     * [base_server]
     * ram = 16G
     * disk = 15G
     *
     * [review_console:admin_console]
     *
     * [admin_console:base_server]
     * ram = 32G
     * owner = root
     *
     *
     *
     * output:
     * [admin_console]
     * disk = 16G
     * owner = root
     * ram = 32G
     *
     * [base_server]
     * disk = 16G
     * ram = 16G
     *
     * [review_console]
     * disk = 16G
     * owner = root
     * ram = 32G
     *
     *
     * @param input
     */
    public void getValues(String[] input) {

        // map stores the configurations of each server
        Map<String, Map<String, String>> config = new HashMap<>();

        // use adj map to save parent and its children
        // construct a graph
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        String s1 = "";


        // traverse through all lines to store the original property for each server
        // and construct a graph to save the relationship between different servers

        // time: O(N)
        for (String s: input) {

            // server ID line
            if (!s.contains("=")) {

                // get rid of brackets [ ]
                s = s.substring(1, s.length() - 1);
                s1 = s;

                // contains extension relationship:  [admin_console:base_server]
                // inherits parent's property, but not overridden
                if (s.contains(":")) {
                    s1 = s.split(":")[0];
                    String s2 = s.split(":")[1];

                    // s1 is the child of s2
                    // add s1 into the value of s2 in the adj map
                    if (!adj.containsKey(s2)) {
                        adj.put(s2, new LinkedList<>());
                    }
                    adj.get(s2).add(s1);

                    // increase the indegree of s1
                    indegree.put(s1, indegree.getOrDefault(s1, 0) + 1);
                }
                if (!indegree.containsKey(s1)) {
                    indegree.put(s1, 0);
                }
                config.put(s1, new HashMap<>());
            }

            else {
                // parse the configuration section, and add it into map
                s = s.replaceAll(" ", "");
                config.get(s1).put(s.split("=")[0], s.split("=")[1]);
            }
        }


        // topological sort for the graph to update properties for each server
        // server IDs in the q has indegree of 0

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
            Map<String, String> map1 = config.get(tmp);

            if (adj.containsKey(tmp)) {
                List<String> neigh = adj.get(tmp);
                for (String n: neigh) {

                    // inherit new properties form parent
                    Map<String, String> map2 = config.get(n);
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

        // sort server IDs in alphabetic order and output
        // time: O(NlogN)
        Collections.sort(res, (a,b) -> (a.compareTo(b)));

        for (String s: res) {
            System.out.println("[" + s + "]");
            Map<String, String> m = config.get(s);
            List<String> key = new ArrayList<>(m.keySet());
            Collections.sort(key);

            for (String str: key) {
                System.out.println(str + " = " + m.get(str));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] input = {"[base_server]", "ram = 16G", "disk = 15G", "[review_console:admin_console]",
                "[admin_console:base_server]", "ram = 32G", "owner = root"};
//        String[] input = {"[staging_server:base_server]", "ram = 8G", "envname = Staging",
//                "[dev_server:staging_server]", "envname = Dev", "[test_server:dev_server]", "disk = 4G",
//                "[base_server]", "ram = 16G", "disk = 15G", "[qa_server:base_server]", "ram = 4G"};
        new ConfigurationValues_OA().getValues(input);
    }
}
