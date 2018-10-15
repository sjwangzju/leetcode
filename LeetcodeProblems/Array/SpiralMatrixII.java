package Array;

/**
 * Created by sjwang on 10/14/2018.
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] tmp = new int[n][n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int cur = 1, i = 0, j = 0, index = 0;
        while (cur <= n * n) {
            tmp[i][j] = cur;
            if (noWay(i, j, dir[index], n, tmp)) {
                index++;
                if (index == 4) {
                    index = 0;
                }
            }
            i = i + dir[index][0];
            j = j + dir[index][1];
            cur++;
        }
        return tmp;
    }

    public boolean noWay(int i, int j, int[] dir, int n, int[][] tmp) {
        i = i + dir[0];
        j = j + dir[1];
        if (j == n || j < 0 || i == n || tmp[i][j] != 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        int n = 4;
        int[][] tmp = new SpiralMatrixII().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(tmp[i][j]);
            }
        }
    }
}
