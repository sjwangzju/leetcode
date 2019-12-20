package FullTime.OCI;

public class MultiplyStrings {

    // Given two non-negative integers num1 and num2 represented as strings,
    // return the product of num1 and num2, also represented as a string
    //
    // Input: num1 = "123", num2 = "456"
    // Output: "56088"
    //
    // Thoughts:
    // 1. result: int[] res = new int[l1+l2]
    // 2. num1[i]*num2[j] should be put at index (i+j) and (i+j+1)
    //
    // time: O(L1*L2), space: O(L1+L2)
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1 + l2];

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int n1 = num1.charAt(i) - '0', n2 = num2.charAt(j) - '0';

                int cur = n1 * n2 + res[p2];
                res[p2] = cur % 10;
                res[p1] += cur / 10;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && s.length() == 0) continue;
            s.append(res[i]);
        }
        return s.length() == 0? "0": s.toString();
    }
}
