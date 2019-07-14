package FullTime.FB;

import java.util.*;

/**
 * BFS
 *
 * time: O(10^N)
 * space: O(10^N)
 */
public class LC752_OpenTheLock_M {

    Set<String> visited;
    Set<String> dead;
    Queue<String> q;
    public int openLock(String[] deadends, String target) {
        visited = new HashSet<>();
        dead = new HashSet<>(Arrays.asList(deadends));
        q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                helper(cur);
            }
            step++;
        }
        return -1;
    }

    public void helper(String cur) {
        for (int i = 0; i < cur.length(); i++) {
            char[] c1 = cur.toCharArray();
            char[] c2 = cur.toCharArray();
            c1[i] = c1[i] == '9'? '0': (char)(c1[i] + 1);
            c2[i] = c2[i] == '0'? '9': (char)(c1[i] - 1);
            add(c1);
            add(c2);
        }
    }

    public void add(char[] c) {
        String s = new String(c);
        if (!visited.contains(s) && !dead.contains(s)) {
            visited.add(s);
            q.offer(s);
        }
    }

    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(new LC752_OpenTheLock_M().openLock(deadends, target));
    }
}
