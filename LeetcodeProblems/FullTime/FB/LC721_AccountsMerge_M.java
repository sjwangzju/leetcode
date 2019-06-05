package FullTime.FB;

import java.util.*;

/**
 * Solution1: Construct Graph -> BFS
 *
 * time: O(sum(ai*lg(ai)))
 *
 *
 * Solution2: Union Find
 *
 * time: O(AlogA), A = sum(ai)
 *
 */
public class LC721_AccountsMerge_M {
    public List<List<String>> accountsMergeI(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> emailGroup = new HashMap<>();

        // construct the graph
        for (List<String> account: accounts) {
            String curName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String curEmail = account.get(i);
                emailGroup.computeIfAbsent(account.get(1), x -> new LinkedList<>()).add(curEmail);
                emailGroup.computeIfAbsent(curEmail, x -> new LinkedList<>()).add(account.get(1));
                emailToName.put(account.get(i), curName);
            }
        }

        List<List<String>> res = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (String s: emailGroup.keySet()) {
            if (!visited.contains(s)) {
                List<String> tmp = new LinkedList<>();
                Queue<String> queue = new LinkedList<>();
                queue.offer(s);
                visited.add(s);
                while (!queue.isEmpty()) {
                    String cur = queue.poll();
                    tmp.add(cur);
                    for (String adj: emailGroup.get(cur)) {
                        if (!visited.contains(adj)) {
                            queue.offer(adj);
                            visited.add(adj);
                        }
                    }
                }
                Collections.sort(tmp);
                tmp.add(0, emailToName.get(s));
                res.add(tmp);
            }
        }
        return res;
    }


    public List<List<String>> accountsMergeII(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();
        int[] parent = new int[1001];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int id = 0;
        for (List<String> account: accounts) {
            String curName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String curEmail = account.get(i);

                if (!emailToID.containsKey(curEmail)) {
                    emailToID.put(curEmail, id++);
                }
                union(parent, emailToID.get(account.get(1)), emailToID.get(curEmail));
                emailToName.put(account.get(i), curName);
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();

        for (String email: emailToID.keySet()) {
            int cur = findParent(parent, emailToID.get(email));
            map.computeIfAbsent(cur, x -> new LinkedList<>()).add(email);
        }

        for (List<String> list: map.values()) {
           Collections.sort(list);
           list.add(0, emailToName.get(list.get(0)));
        }
        return new ArrayList<>(map.values());
    }

    public int findParent(int[] parent, int n) {
        if (parent[n] != n) {
            return findParent(parent, parent[n]);
        }
        return parent[n];
    }

    public void union(int[] parent, int i, int j) {
        int pi = findParent(parent, i);
        int pj = findParent(parent, j);
        parent[pj] = pi;
    }

    public static void main(String[] args) {
        List<String> a1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> a2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> a3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> a4 = Arrays.asList("Mary", "mary@mail.com");
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        System.out.println(new LC721_AccountsMerge_M().accountsMergeII(accounts));
    }
}
