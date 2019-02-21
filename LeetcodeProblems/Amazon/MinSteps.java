package Amazon;

public class MinSteps {

    /**
     * DFS - time: O(logN), space: O(1)
     *
     * @param n
     * @return
     */
    public int findMinStep(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 1) return 0;
        if (n % 2 == 1) {
            return 1 + Math.min(dfs(n - 1), dfs(n + 1));
        }
        return 1 + dfs(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(new MinSteps().findMinStep(5));
    }
}
