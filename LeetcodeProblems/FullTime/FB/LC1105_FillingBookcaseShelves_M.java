package FullTime.FB;

/**
 * DFS + memory
 *
 * time: O(N)
 * space: O(N*W), N is num of books, W is shelf-width
 */
public class LC1105_FillingBookcaseShelves_M {

    int[][] dp;
    public int minHeightShelves(int[][] books, int shelf_width) {
        dp = new int[books.length + 1][shelf_width + 1];
        return minHeight(books, shelf_width, 0, 0, shelf_width);
    }

    public int minHeight(int[][] books, int widthLeft, int i, int curHeight, int shelf_width) {
        if (i == books.length) {
            return curHeight;
        }
        if (dp[i][widthLeft] != 0) {
            return dp[i][widthLeft];
        }

        // put on a new shelf
        dp[i][widthLeft] = curHeight + minHeight(books, shelf_width - books[i][0], i + 1, books[i][1], shelf_width);

        // put on the prev shelf
        if (widthLeft >= books[i][0]) {
            int h = minHeight(books, widthLeft - books[i][0], i + 1, Math.max(curHeight, books[i][1]), shelf_width);
            dp[i][widthLeft] = Math.min(dp[i][widthLeft], h);
        }
        return dp[i][widthLeft];
    }

    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int self_width = 4;
        System.out.println(new LC1105_FillingBookcaseShelves_M().minHeightShelves(books, self_width));
    }
}
