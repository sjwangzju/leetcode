package FullTime.FB;

//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//Note:
//The length of both num1 and num2 is < 5100.
//Both num1 and num2 contains only digits 0-9.
//Both num1 and num2 does not contain any leading zero.
//You must not use any built-in BigInteger library or convert the inputs to integer directly.

/**
 * Two pointers
 *
 * time: O(M+N)
 * space: O(M+N)
 */
public class LC415_AddStrings_E {

    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int add = 0;
        StringBuilder res = new StringBuilder();

        while (l1 >= 0 || l2 >= 0) {
            int cur = add;
            if (l1 >= 0) {
                cur += num1.charAt(l1--) - '0';
            }
            if (l2 >= 0) {
                cur += num2.charAt(l2--) - '0';
            }
            res.insert(0, cur % 10);
            add = cur / 10;
        }
        if (add == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "9";
        System.out.println(new LC415_AddStrings_E().addStrings(num1, num2));
    }
}
