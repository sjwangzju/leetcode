package FullTime.FB;

public class LC67_AddBinary_E {

    /**
     * add from low digit to high digit, and reverse the result
     *
     * time: O(max(L1, L2)), L1 - len of str a, L2 - len of str b
     * space: O(1)
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int sum = 0;
        int add = 0;
        StringBuilder res = new StringBuilder();

        while (l1 > 0 || l2 > 0) {
            sum = add;
            if (l1 > 0) {
                sum += a.charAt(l1 - 1) - '0';
                l1--;
            }
            if (l2 > 0) {
                sum += b.charAt(l2 - 1) - '0';
                l2--;
            }
            res.append(sum % 2);
            add = sum / 2;
        }
        if (add > 0) res.append(add);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC67_AddBinary_E().addBinary("1010", "1011"));
    }
}
