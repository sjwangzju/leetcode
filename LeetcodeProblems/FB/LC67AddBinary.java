package FB;

public class LC67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        if (a.length() < b.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }
        int len1 = a.length();
        int len2 = b.length();
        int add = 0;
        for (int i = 0; i < len1; i++) {
            int n1 = a.charAt(len1 - 1 - i) - '0';
            int n2;
            if (len2 - 1 - i < 0) {
                n2 = 0;
            } else {
                n2 = b.charAt(len2 - 1 - i) - '0';
            }
            int cur = n1 + n2 + add;
            add = 0;
            if (cur >= 2) {
                cur -= 2;
                add = 1;
            }
            res.insert(0, cur);
        }
        if (add == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "110";
        System.out.println(new LC67AddBinary().addBinary(a, b));
    }

}
