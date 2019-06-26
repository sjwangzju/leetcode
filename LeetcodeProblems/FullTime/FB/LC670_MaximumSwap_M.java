package FullTime.FB;

public class LC670_MaximumSwap_M {

    // linear search, start from last index
    // time: O(N)
    // space: O(N)
    public int maximumSwapI(int num) {
        char[] chs = Integer.toString(num).toCharArray();
        int max = -1, m = -1, n = -1, s1 = -1, s2 = -1;

        for (int i = chs.length - 1; i >= 0; i--) {
            int cur = chs[i] - '0';
            if (cur > max) {
                if (n != -1 && n < m) {
                    s1 = n;
                    s2 = m;
                }
                max = cur;
                m = i;
                n = -1;
            } else if (cur < max) {
                n = i;
            }
        }
        if (n != -1 && n < m) {
            s1 = n;
            s2 = m;
        }
        if (s1 != -1 && s2 != -1) {
            char ch = chs[s1];
            chs[s1] = chs[s2];
            chs[s2] = ch;
        }
        return Integer.valueOf(new String(chs));
    }

    // save the max index of each digit
    // time: O(10*N)
    // space: O(N)
    public int maximumSwapII(int num) {
        char[] chs = Integer.toString(num).toCharArray();
        int[] pos = new int[10];

        for (int i = 0; i < chs.length; i++) {
            pos[chs[i] - '0'] = i;
        }

        for (int i = 0; i < chs.length; i++) {
            for (int j = 9; j > chs[i] - '0'; j--) {
                if (pos[j] > i) {
                    char ch = chs[i];
                    chs[i] = chs[pos[j]];
                    chs[pos[j]] = ch;
                    return Integer.valueOf(new String(chs));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new LC670_MaximumSwap_M().maximumSwapI(2736));
    }
}
