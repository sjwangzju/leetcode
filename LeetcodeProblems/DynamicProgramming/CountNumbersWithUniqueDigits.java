package DynamicProgramming;

/**
 * Created by sjwang on 08/18/2018.
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 0;
        int sum = 10, rest = 9, temp = 9;
        while(n > 1) {
            temp *= rest--;
            sum += temp;
            n--;
        }
        return sum;
    }
    public static void main(String args[]) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
    }
}
