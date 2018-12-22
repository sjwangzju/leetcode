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
    public int slidingPuzzle(int[][] board) {
        int cnt = 0;
        String target = "123456780";
        String cur = "";

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cur += board[i][j];
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(cur);
        visited.add(cur);
        Map<String, String> map = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String tmp = q.poll();
                if (tmp.equals(target)) {
                    printPath(map, cnt, target);
                    return cnt;
                }
                int zero = tmp.indexOf('0');

                List<Integer> neigh = getNeighbour(row, col, zero);

                StringBuilder key = new StringBuilder(tmp);

                for (int n: neigh) {
                    String ss = swap(tmp, zero, n);
                    if (!visited.contains(ss)) {
                        visited.add(ss);
                        q.offer(ss);
                        map.put(ss, key.toString());
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public void printPath(Map<String, String> map, int steps, String target) {
        String tmp = target;
        System.out.println(tmp);
        while (steps > 0) {
            tmp = map.get(tmp);
            System.out.println(tmp);
            steps--;
        }
    }

    public String swap(String s, int i, int j) {
        StringBuilder res = new StringBuilder(s);
        res.setCharAt(i, s.charAt(j));
        res.setCharAt(j, s.charAt(i));
        return res.toString();
    }

    public List<Integer> getNeighbour(int row, int col, int index) {
        List<Integer> res = new ArrayList<>();
        int i = index / col;
        int j = index % col;
        if (i - 1 >= 0) {
            res.add((i - 1) * col + j);
        }
        if (i + 1 < row) {
            res.add((i + 1) * col + j);
        }
        if (j - 1 >= 0) {
            res.add(i * col + j - 1);
        }
        if (j + 1 < col) {
            res.add(i * col + j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] board = {{2,3,0},{1,5,6},{4,7,8}};
        System.out.println(new SlidingPuzzle_19().slidingPuzzle(board));
//        System.out.println(new SlidingPuzzle_19().getNeighbour(2,3,4));
    }
}
