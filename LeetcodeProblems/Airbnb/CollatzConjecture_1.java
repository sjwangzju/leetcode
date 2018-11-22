package Airbnb;

public class CollatzConjecture_1 {
    public int solution(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int step = stepNum(i, 1);
            max = Math.max(step, max);
        }
        return max;
    }

    public int stepNum(int n, int step) {
        if (n == 1) {
            return step;
        }
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = 3 * n + 1;
        }
        return stepNum(n, step + 1);
    }

    public static void main(String[] args) {
        System.out.println(new CollatzConjecture_1().solution(10));
    }
}
