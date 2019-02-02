package Google;

public class LC904FruitIntoBaskets {

    /**
     * time: O(N), space: O(1)
     *
     * ...aaabbc
     *
     * @param tree
     * @return
     */
    public int totalFruitI(int[] tree) {
        int max = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        int count_b = 0;
        int cur = 0;
        for (int t: tree) {
            cur = t == a || t == b ? cur + 1 : count_b + 1;
            count_b = t == b ? count_b + 1 : 1;
            if (t != b) {
                a = b;
                b = t;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] tree = {2,2,2,2,2,1,0,0,0,1};
        System.out.println(new LC904FruitIntoBaskets().totalFruitI(tree));
    }
}
