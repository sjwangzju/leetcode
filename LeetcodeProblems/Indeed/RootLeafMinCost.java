package Indeed;

import java.util.LinkedList;
import java.util.List;

public class RootLeafMinCost {

    public static class Node {
        List<Edge> edges;

        public Node() {
            this.edges = new LinkedList<>();
        }
    }

    public static class Edge {
        Node endNode;
        int cost;

        public Edge(Node end, int cost) {
            this.endNode = end;
            this.cost = cost;
        }
    }

    int min = Integer.MAX_VALUE;

    public List<Edge> minCost(Node root) {
        if (root == null) return null;
        List<Edge> res = new LinkedList<>();
        List<Edge> tmp = new LinkedList<>();
        dfs(res, tmp, root, 0);
        return res;
    }

    public void dfs(List<Edge> res, List<Edge> tmp, Node n, int curCost) {
        if (n == null) {
            return;
        }
        if (n.edges.size() == 0) {
            if (curCost < min) {
                min = curCost;
                res.clear();
                res.addAll(tmp);
            }
            return;
        }
        List<Edge> list = n.edges;
        for (Edge e: list) {
            tmp.add(e);
            dfs(res, tmp, e.endNode, curCost + e.cost);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n21 = new Node();
        Node n22 = new Node();
        Node n23 = new Node();
        Node n31 = new Node();
        Node n32 = new Node();

        Edge e1 = new Edge(n21, -15);
        Edge e2 = new Edge(n22, -5);
        Edge e3 = new Edge(n23, 10);
        Edge e4 = new Edge(n31, -1);
        Edge e5 = new Edge(n32, 30);

        n1.edges.add(e1);
        n1.edges.add(e2);
        n1.edges.add(e3);

        n21.edges.add(e4);
        n21.edges.add(e5);

        List<Edge> list = new RootLeafMinCost().minCost(n1);
        for (Edge e: list) {
            System.out.println(e.cost);
        }
    }

}
