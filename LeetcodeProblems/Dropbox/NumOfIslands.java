package Dropbox;

import java.util.LinkedList;
import java.util.List;

public class NumOfIslands {

    /****************************************************************************************/
    // find the max area
    public int numOfIslandsI(int[][] input) {
        int max = 0;
        int row = input.length;
        int col = input[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i][j] == 1) {
                    max = Math.max(max, dfs(input, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] input, int i, int j) {
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int row = input.length;
        int col = input[0].length;
        input[i][j] = 0;

        int cnt = 1;
        for (int[] dir: dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti >= 0 && nexti < row && nextj >= 0 && nextj < col && input[nexti][nextj] == 1) {
                cnt += dfs(input, nexti, nextj);
            }
        }
        return cnt;
    }



    /****************************************************************************************/
    // add islands
    // find the num of islands after each operation
    // union find

    public List<Integer> numIslandsII(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList<>();

        int[] parent = new int[m * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        int cnt = 0;
        for (int[] pos: positions) {
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            cnt ++;

            int cur = pos[0] * n + pos[1];
            parent[cur] = cur;

            for (int[] dir: dirs) {
                int nexti = pos[0] + dir[0];
                int nextj = pos[1] + dir[1];
                if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n
                        && parent[nexti * n + nextj] != -1) {
                    int p1 = findParent(nexti * n + nextj, parent);
                    int p2 = findParent(cur, parent);
                    if (p1 != p2) {
                        parent[p2] = p1;
                        cnt--;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    public int findParent(int n, int[] parent) {
        while (n != parent[n]) {
            n = parent[n];
        }
        return n;
    }


    public static void main(String[] args) {
        int[][] input = {{1,1,0,1,0},{1,1,0,1,0},{0,0,0,0,1}};
        System.out.println(new NumOfIslands().numOfIslandsI(input));
    }
}
