package FB;

public class IntegerCombinationsEqualsK {

    /**
     * backtracking, time: O(N^2), space: O(N)
     * @param input
     * @param K
     * @param cur
     * @param cnt
     */
    public void findCombinations(String input, int K, StringBuilder cur, int cnt) {
        if (cnt == 9) {
            if (K == 0) {
                String res = cur.toString();
                if (res.charAt(0) == '+') {
                    res = res.substring(1);
                }
                System.out.println(res);
            }
            return;
        }
        int len = input.length();
        for (int i = 1; i <= len; i++) {
            String sub = input.substring(0, i);

            findCombinations(input.substring(i), K - Integer.parseInt(sub),
                    cur.append("+" + sub), cnt + sub.length());
            int index1 = cur.lastIndexOf("+");
            cur.delete(index1, cur.length());

            findCombinations(input.substring(i), K + Integer.parseInt(sub),
                    cur.append("-" + sub), cnt + sub.length());
            int index2 = cur.lastIndexOf("-");
            cur.delete(index2, cur.length());
        }
    }

    public static void main(String[] args) {
        String input = "123456789";
        int K = 100;
        new IntegerCombinationsEqualsK().findCombinations(input, K, new StringBuilder(), 0);
    }
}
