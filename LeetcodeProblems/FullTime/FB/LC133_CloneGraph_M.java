package FullTime.FB;

import java.util.*;

public class LC133_CloneGraph_M {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // BFS
    public Node cloneGraphI(Node node) {
        if (node == null) return null;

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        q.offer(node);
        map.put(node, new Node(node.val, new LinkedList<>()));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.neighbors != null) {
                for (Node n: cur.neighbors) {
                    if (!map.containsKey(n)) {
                        map.put(n, new Node(n.val, new LinkedList<>()));
                        q.offer(n);
                    }
                    map.get(cur).neighbors.add(map.get(n));
                }
            }
        }
        return map.get(node);
    }

    // DFS
    public Node cloneGraphII(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new LinkedList<>()));
        dfs(map, node);

        return map.get(node);
    }

    public void dfs(Map<Node, Node> map, Node cur) {
        if (cur.neighbors != null) {
            for (Node n: cur.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val, new LinkedList<>()));
                    dfs(map, n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
    }
}
