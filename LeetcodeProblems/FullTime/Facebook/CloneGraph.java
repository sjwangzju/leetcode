package FullTime.Facebook;

import java.util.*;

public class CloneGraph {

    public class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {}
        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
    // Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
    //
    // Solution1: BFS
    //
    // time: O(N), space: O(N)
    public Node cloneGraphI(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node n: cur.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val, new ArrayList<>()));
                    q.offer(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }


    // Solution2: DFS
    // time: O(N), space: O(N)
    /********************************************************/
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraphII(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) return map.get(node);

        Node res = new Node(node.val, new ArrayList<>());
        map.put(node, res);

        for (Node n: node.neighbors) {
            res.neighbors.add(cloneGraphII(n));
        }
        return res;
    }
}
