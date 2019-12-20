package FullTime.Facebook;

public class MultiplyStrings {

    // Given two non-negative integers num1 and num2 represented as strings,
    // return the product of num1 and num2, also represented as a string.
    //
    // Input: num1 = "123", num2 = "456"
    // Output: "56088"
    //
    // Thoughts:
    // 1. Graph: num1[i] * num2[j] will be at index (i+j, i+j+1)
    //
    // time: O(M*N), space: O(M+N)
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0', n2 = num2.charAt(j) - '0';
                int p1 = i + j, p2 = i + j + 1;
                int tmp = n1 * n2 + res[p2];

                res[p1] += tmp / 10;
                res[p2] = tmp % 10;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (s.length() == 0 && res[i] == 0) continue;
            s.append(res[i]);
        }
        return s.length() == 0? "0": s.toString();
    }

}
