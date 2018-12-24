package Airbnb;

import java.util.Arrays;
import java.util.List;

public class BoardScore {

    /**
     * BFS + visited
     *
     * time: O(M * N), space: O(M * N)
     *
     * @param board
     * @return
     */
    public int boardScore(List<String> board) {
        int row = board.size();
        int col = board.get(0).split(" ").length;
        String[][] map = new String[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = board.get(i).split(" ");
        }
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    int[] area = new int[1];
                    int[] crown = new int[1];
                    String type = map[i][j].substring(0,1);
                    getScore(map, i, j, visited, type, area, crown);
                    res += area[0] * crown[0];
                }
            }
        }
        return res;
    }

    public void getScore(String[][] map, int i, int j, boolean[][] visited, String type, int[] area, int[] crown) {
        int row = map.length;
        int col = map[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || !map[i][j].substring(0,1).equals(type)) {
            return;
        }
        int num = Integer.parseInt(map[i][j].substring(1,2));
        visited[i][j] = true;
        area[0] += 1;
        crown[0] += num;

        getScore(map, i + 1, j, visited, type, area, crown);
        getScore(map, i - 1, j, visited, type, area, crown);
        getScore(map, i , j + 1, visited, type, area, crown);
        getScore(map, i , j - 1, visited, type, area, crown);

        return;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("S0 W1 W1 W0 L2","W0 W0 T0 T0 T0","W0 W1 T0 M2 M1","S0 L0 S1 S0 S0","M0 R2 R0 S1 T0");
        System.out.println(new BoardScore().boardScore(input));
    }
}
