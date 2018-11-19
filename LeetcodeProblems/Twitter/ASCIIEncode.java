package Twitter;

public class ASCIIEncode {
    public String decode(String encoded) {
        int pos = 0;
        String reversed_encoded = reverse(encoded);
        String ret = "";
        while(pos < reversed_encoded.length()) {
            char cur = reversed_encoded.charAt(pos);
            if (cur == '3') {
                ret = ret + " ";
                pos += 2;
            } else if (cur == '1') {
                int n = Integer.valueOf(reversed_encoded.substring(pos, pos + 3));
                char tmp = (char)(n - 97 + 'a');
                ret = ret + tmp;
                pos += 3;
            } else {
                int n = Integer.valueOf(reversed_encoded.substring(pos, pos + 2));
                char tmp = n > 90 ? (char)(n - 97 + 'a') : (char)(n - 65 + 'A');
                ret = ret + tmp;
                pos += 2;
            }
        }
        return ret;
    }

    public String reverse (String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        while (i <= s.length() / 2 - 1) {
            char tmp = ch[i];
            ch[i] = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = tmp;
            i++;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String encoded = "1219950180111108236115111016623101401611235115012312161151110101111127";
        System.out.println(new ASCIIEncode().decode(encoded));
    }
}
