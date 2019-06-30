package FullTime.FB;

/**
 * DP
 *
 * time: O(N^2)
 * space: O(N)
 */
public class LC1105_FillingBookcaseShelves_M {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length];

        for (int i = 0; i < books.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            int curWidth = 0;
            int curMaxHeight = Integer.MIN_VALUE;

            for (int j = i; j >= 0; j--) {
                curWidth += books[j][0];
                curMaxHeight = Math.max(curMaxHeight, books[j][1]);
                if (curWidth > shelf_width) break;

                int curH = curMaxHeight + (j >= 1? dp[j - 1]: 0);
                dp[i] = Math.min(dp[i], curH);
            }
        }
        return dp[books.length - 1];
    }

    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int self_width = 4;
        System.out.println(new LC1105_FillingBookcaseShelves_M().minHeightShelves(books, self_width));
    }
}
