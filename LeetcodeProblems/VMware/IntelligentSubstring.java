package VMware;

public class IntelligentSubstring {

    public int getSpecialSubstring(String s, String charValue, int k) {
        char[] chs = charValue.toCharArray();
        int l = 0;
        int r = 0;
        int cnt = 0;
        int max = 0;

        while (l <= r && r < s.length()) {

            if (chs[r] == '0') {
                cnt++;
            }

            if (cnt > k) {
                while (l < r && chs[l] != '0') {
                    l++;
                }
                l++;
                cnt--;
            }

            if (cnt == k) {
                int tmp = r + 1;
                while (tmp < s.length() && chs[tmp] != '0') {
                    tmp++;
                }
                max = Math.max(max, tmp - l);
            }

            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String charValue = "10101111111111111111111111";
        System.out.println(new IntelligentSubstring().getSpecialSubstring(s, charValue, 1));
    }
}
