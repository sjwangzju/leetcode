package FullTime.Facebook;

import java.util.*;

public class EvaluateDivision {

    // Example:
    // Given a / b = 2.0, b / c = 3.0.
    // queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    // return [6.0, 0.5, -1.0, 1.0, -1.0 ].
    //
    // Graph + DFS
    // time: O(N*(V+E)), space: O(V+E)
    //
    Map<String, Map<String, Double>> map = new HashMap<>();
    double[] res;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        res = new double[queries.size()];
        Arrays.fill(res, -1);

        // build graph
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            if (!map.containsKey(s1)) map.put(s1, new HashMap<>());
            if (!map.containsKey(s2)) map.put(s2, new HashMap<>());
            map.get(s1).put(s2, values[i]);
            map.get(s2).put(s1, 1/values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);

            res[i] = getVal(s1, s2, new HashSet<>(), 1.0);
        }
        return res;
    }

    // DFS
    public double getVal(String cur, String s2, Set<String> visited, double d) {
        if (!map.containsKey(cur)) return -1.0;
        if (cur.equals(s2)) {
            return d;
        }

        Map<String, Double> m = map.get(cur);
        for (String s: m.keySet()) {
            if (visited.contains(s)) continue;

            visited.add(s);

            double next = getVal(s, s2, visited, d * m.get(s));
            if (next != -1.0) return next;

            visited.remove(s);
        }
        return -1.0;
    }
}
