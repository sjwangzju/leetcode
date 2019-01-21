package TuSimple;

import java.util.LinkedList;
import java.util.List;

public class NumberOfIslandsII {


    /**
     * union find
     *
     * time: O(M*N), space: O(M*N)
     *
     * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        int cnt = 0;
        for (int[] pos: positions) {
            int i = pos[0];
            int j = pos[1];
            int curPos = i * n + j;
            int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

            cnt++;
            parent[curPos] = curPos;

            for (int[] d: dir) {
                int ii = i + d[0];
                int jj = j + d[1];
                int neigh = ii * n + jj;
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && parent[neigh] != -1) {
                    int p1 = findParent(parent, curPos);
                    int p2 = findParent(parent, neigh);
                    if (p1 != p2) {
                        cnt--;
                        parent[p2] = p1;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    public int findParent(int[] parent, int n) {
        while (n != parent[n]) {
            n = parent[n];
        }
        return n;
    }

    public static void main(String[] args) {
        int[][] positions = {{0,0},{1,0},{0,2},{1,2},{1,1},{0,1}};
        List<Integer> res = new NumberOfIslandsII().numIslands2(3,3,positions);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
