package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Astar {
    public List<myNode> findPath(myNode start, myNode goal) {
        List<myNode> todo = new ArrayList<>();
        List<myNode> done = new ArrayList<>();
        List<myNode> path = new ArrayList<>();

        // Add initial state to TODO_list
        todo.add(start);
        myNode last_state = start;
        myNode cur_state = start;
        int cnt = 1;

        // If TODO_list is empty, fail
        while (!todo.isEmpty()) {
            cur_state = findSmallest(todo, last_state);

            // print all the nodes in the open list
            System.out.println("Step " + cnt);
            printOpenList(todo, "before");

            // Move state with smallest g(N)+h(N) from TODO_list to DONE_list
            todo.remove(cur_state);
            done.add(cur_state);

            // print all the nodes in the closed list
            printClosedList(cur_state);
            last_state = cur_state;

            // If reaches goal state, break
            if (cur_state.equals(goal)) {
                todo.remove(cur_state);
                printOpenList(todo, "after");
                System.out.println();
                break;
            }

            // print all the nodes in the open list
            printOpenList(todo, "after");
            System.out.println();

            // Add each successors of current state to TODO_list
            for (myNode n : cur_state.children) {

                // Ensure no successor is the ancestor of current state
                if (!isAncestor(n, cur_state)) {
                    todo.add(n);
                    n.g = cur_state.g + n.C.get(cur_state.name);

                    // Create pointer from s to state
                    n.parent.add(0, cur_state);
                }
            }
            cnt++;
        }

        if (done.size() != 0) {
            myNode cur = done.get(done.size() - 1);
            path.add(cur);
            while (!cur.equals(start)) {
                path.add(0, cur.parent.get(0));
                cur = cur.parent.get(0);
            }
        }
        return path;
    }

    public void printClosedList(myNode cur_state) {
        // print the most recent node added to the closed list
        System.out.println("Recent node added to closed list:");
        System.out.println("Node name: " + cur_state.name + ", predecessor: "
                + cur_state.parent.get(0).name + ", actual cost: " + cur_state.g);
    }

    public void printOpenList(List<myNode> todo, String s) {
        // print all the nodes in the open list
        System.out.println("All the nodes in the open list " + s + ": ");
        for (int i = 0; i < todo.size(); i++) {
            System.out.println("Node name: " + todo.get(i).name + ", predecessor: "
                    + todo.get(i).parent.get(0).name + ", actual cost: " + todo.get(i).g
                    + ", estimated future cost: " + todo.get(i).h + ", total cost: " + (todo.get(i).g + todo.get(i).h));
        }
    }

    public boolean isAncestor(myNode n, myNode last_state) {
        if (last_state.parent.contains(n)) {
            return true;
        }
        return false;
    }

    public myNode findSmallest(List<myNode> todo, myNode last_state) {
        myNode smallest = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < todo.size(); i++) {
            myNode n = todo.get(i);
            int tmp;
            if (n.C.containsKey(last_state.name)) {
                tmp = last_state.g + n.C.get(last_state.name) + n.h;
                n.g = last_state.g + n.C.get(last_state.name);
            } else {
                tmp = n.g + n.h;
            }
            min = Math.min(min, tmp);
            if (tmp == min) {
                smallest = n;
            }
        }
        //System.out.println(smallest.name);
        return smallest;
    }

    public static class myNode {
        String name;
        int h, g = 0;
        Map<String, Integer> C = new HashMap<>();
        List<myNode> parent = new ArrayList<>();
        List<myNode> children = new ArrayList<>();
        public myNode(int h, String name) {
            this.name = name;
            this.h = h;
        }
    }

    public static void main(String args[]) {
        myNode S = new myNode(4, "S");
        myNode A = new myNode(7, "A");
        myNode B = new myNode(3, "B");
        myNode C = new myNode(2, "C");
        myNode D = new myNode(1, "D");
        myNode G = new myNode(0, "G");
        S.children.add(A); A.C.put("S", 1); S.parent.add(S);
        S.children.add(B); B.C.put("S", 1);
        A.children.add(G); G.C.put("A", 7);
        B.children.add(C); C.C.put("B", 1);
        C.children.add(D); D.C.put("C", 1);
        D.children.add(G); G.C.put("D", 7);
        List<myNode> res = new Astar().findPath(S, G);

        System.out.print("Shortest path: ");
        for (int i = 0; i < res.size(); i++) {
            if (i != res.size() - 1) {
                System.out.print(res.get(i).name + " -> ");
            } else {
                System.out.print(res.get(i).name);
            }
        }
    }
}
