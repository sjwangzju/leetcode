package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> Q = new LinkedList<>();
        Q.offer(node);
        UndirectedGraphNode re = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> M = new HashMap<>();
        M.put(node, re);
        while(!Q.isEmpty()) {
            UndirectedGraphNode cur = Q.poll();
            if(cur.neighbors != null) {
                for(UndirectedGraphNode n : cur.neighbors) {
                    if(!M.containsKey(n)) {
                        M.put(n, new UndirectedGraphNode(n.label));
                        Q.offer(n);
                    }
                    M.get(cur).neighbors.add(M.get(n));
                }
            }
        }
        return re;
    }
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    public static void main(String args[]){
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n0.neighbors = new ArrayList<>(Arrays.asList(n1, n2));
        n1.neighbors = new ArrayList<>(Arrays.asList(n2));
        n2.neighbors = new ArrayList<>(Arrays.asList(n2));
        System.out.println(new CloneGraph().cloneGraph(n0));
    }
}
