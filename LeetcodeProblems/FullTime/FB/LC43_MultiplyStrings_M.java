package FullTime.FB;

/**
 * The max len of multiple is l1 + l2, use int[] to save results
 *
 * time: O(l1 * l2)
 * space: O(l1 + l2)
 */
public class LC43_MultiplyStrings_M {

    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1 < l2) {
            return multiply(num2, num1);
        }

        int[] n = new int[l1 + l2];
        for (int i = l2 - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            add(n, mul(num1, n2), l2 - i - 1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n.length - 1; i++) {
            if (res.length() == 0 && n[i] == 0) {
                continue;
            }
            res.append(n[i]);
        }
        res.append(n[n.length - 1]);
        return res.toString();
    }

    public void add(int[] n, String s, int i) {
        int j = n.length - 1 - i;
        for (int k = s.length() - 1; k >= 0; k--) {
            n[j] += s.charAt(k) - '0';
            if (n[j] >= 10) {
                n[j] -= 10;
                n[j - 1] += 1;
            }
            j--;
        }
    }

    public String mul(String num1, int n2) {
        StringBuilder res = new StringBuilder();
        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            double cur = n1 * n2 + add;
            add = (int) cur / 10;
            res.insert(0, (int) cur % 10);
        }
        if (add != 0) {
            res.insert(0, add);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "0", num2 = "456";
        System.out.println(new LC43_MultiplyStrings_M().multiply(num1, num2));
    }
}
