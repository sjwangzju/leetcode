package Dropbox;

public class Sharpness {

    // 2D DP
    // time: O(M*N)
    // space: O(1)
    public int findMax(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int[][] dirs = {{0,-1},{1,-1},{-1,-1}};
                int max = Integer.MIN_VALUE;
                for (int[] dir: dirs) {
                    int previ = i + dir[0];
                    int prevj = j + dir[1];
                    if (previ >= 0 && previ < row && prevj >= 0 && prevj < col) {
                        max = Math.max(max, input[previ][prevj]);
                    }
                }
                input[i][j] = Math.min(input[i][j], max);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            max = Math.max(max, input[i][col - 1]);
        }
        return max;
    }

    //FOLLOW UP
    /****************************************************************************************/
    // 1M * 1M matrix

    // solution1: read the matrix by 2 cols          =>  read: 1M jumps, write: 0  jumps  => total: 1M * 0.5M jumps


    // prove:
    // assume block size is i * j                    => read: i jumps,   write: j jumps   => total: (i + j) * 1M/i * 1M/j
    // Conclusion: when i == j and get the largest i, we can get the smallest num of jumps

    // solution2: read the matrix by block 1k * 1k   =>  read: 1k jumps, write: 1k jumps  => total: 2k * 1k * 1k = 1M * 2k jumps

    // the first line of the next block should be the same as the last line of the previous block


    public static void main(String[] args) {
        int[][] input = {{5,7,2},{7,5,8},{9,1,5}};
        System.out.println(new Sharpness().findMax(input));
    }
}
