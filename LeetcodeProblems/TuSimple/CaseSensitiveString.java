package TuSimple;

public class CaseSensitiveString {

    /**
     * time: O(N), space: O(N)
     * @param s
     * @return
     */
    public String move(String s) {
        int low = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                low++;
            }
        }

        char[] chs = s.toCharArray();
        int cnt = 0;
        int lo = 0;
        int hi = chs.length - 1;

        while (lo < chs.length) {
            char cur = chs[lo];
            if (cur >= 'A' && cur <= 'Z') {
                swap(chs, lo, hi--);
            } else {
                lo++;
                cnt++;
            }
            if (cnt == low) break;
        }
        return String.valueOf(chs);
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "AbCd";
        System.out.println(new CaseSensitiveString().move(s));
    }
}
