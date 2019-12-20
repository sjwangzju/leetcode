package FullTime.Facebook;

public class AddBinary {

    // Input: a = "1010", b = "1011"
    // Output: "10101"
    //
    // Iteration
    //
    // time: O(M+N), space: O(M+N)
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        int prev = 0;
        while (i >= 0 || j >= 0) {
            int cur = prev;
            if (i >= 0) cur += a.charAt(i--) - '0';
            if (j >= 0) cur += b.charAt(j--) - '0';
            prev = cur / 2;
            res.insert(0, cur % 2);
        }
        if (prev != 0) res.insert(0, 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1111", b = "1111";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
