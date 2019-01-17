package VMware;

public class IntelligentSubstring {

    public int maxLength(String s, int k) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = 0;
        int cnt = 0;
        int max = 0;
        while (l <= r) {
            if (cnt > k) {
                while(chs[l] != '0' && l < r) {
                    l++;
                }
                cnt--;
                l++;
            } else {
                while (r < s.length() - 1 && chs[r] != '0') {
                    r++;
                }
                if (r == s.length() - 1) return r - l + 1;
                cnt++;
                r++;
                if (cnt <= k) max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "101010001101011";
        System.out.println(new IntelligentSubstring().maxLength(s, 2));
    }
}
