package FB;

public class LC67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int add = 0;
        while (n1 >= 0 || n2 >= 0) {
            int sum = add;
            if (n1 >= 0) sum += a.charAt(n1--) - '0';
            if (n2 >= 0) sum += b.charAt(n2--) - '0';
            res.append(sum % 2);
            add = sum / 2;
        }
        if (add != 0) res.append(add);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "110";
        System.out.println(new LC67AddBinary().addBinary(a, b));
    }

}
