package Airbnb;

import java.util.*;

public class SlidingPuzzle_19 {

    /**
     * BFS + queue, time: O((M*N)!), space: O((M*N)!)
     *
     * Followup: print all the paths
     *
     * @param board
     * @return
     */
    public static int slidingPuzzle(int[][] board) {
        int cnt = 0;
        int row = board.length;
        int col = board[0].length;
        String tmp ="";
        String target = "123456780";
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp += board[i][j] + "";
            }
        }

        Queue<String> q = new LinkedList<>();
        q.offer(tmp);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    printPath(parent, target, tmp);
                    return cnt;
                }
                int zero = cur.indexOf('0');
                List<String> myNeigh = getNeigh(zero, board, cur);
                for (String n: myNeigh) {
                    if (!visited.contains(n)) {
                        q.offer(n);
                        visited.add(n);
                        parent.put(n, cur);
                    }
                }
                size--;
            }
            cnt++;
        }
        return -1;
    }


    public static void printPath(Map<String, String> parent, String target, String tmp) {
        StringBuilder res = new StringBuilder();
        res.append(target);
        while (!target.equals(tmp)) {
            target = parent.get(target);
            res.insert(0, target + " ");
        }
        System.out.println(res.toString());
    }

    public static List<String> getNeigh(int index, int[][] board, String cur) {
        int row = board.length;
        int col = board[0].length;
        int i = index / col;
        int j = index % col;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        List<String> ret = new LinkedList<>();

        for (int[] d: dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < row && nextj >= 0 && nextj < col) {
                int nextIndex = nexti * col + nextj;
                String neigh = afterSwap(cur, index, nextIndex);
                ret.add(neigh);
            }
        }
        return ret;
    }


    public static String afterSwap(String cur, int index, int newIndex) {
        StringBuilder res = new StringBuilder(cur);
        res.setCharAt(index, cur.charAt(newIndex));
        res.setCharAt(newIndex, cur.charAt(index));
        return res.toString();
    }

    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,0,6},{7,5,8}};
        System.out.println(new SlidingPuzzle_19().slidingPuzzle(board));
//        System.out.println(new SlidingPuzzle_19().getNeighbour(2,3,4));
    }
}
