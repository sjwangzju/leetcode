package Twitter;

import java.util.HashMap;

public class TheHuffmanDecoder {
    public String decode (String[] codes, String encoded) {
        HashMap<String, String> encodeMap = new HashMap<>();
        for (String code: codes) {
            String[] tmp = code.split("\t");
            encodeMap.put(tmp[1], tmp[0]);
        }
        int num = encoded.length() / 6;
        String res = "";
        for (int i = 0; i < num; i++) {
            String s = encoded.substring(6 * i, 6 * (i + 1));
            String c = encodeMap.get(s);
            if (c.equals("[newline]")) {
                c = "\n";
            }
            res = res + c;
        }
        return res;
    }
    public static void main(String[] args) {
        String[] codes = new String[7];
        codes[0] = "a\t100100";
        codes[1] = "b\t100101";
        codes[2] = "c\t110001";
        codes[3] = "d\t100000";
        codes[4] = "[newline]\t111111";
        codes[5] = "p\t111110";
        codes[6] = "q\t000001";
        String encoded = "111110000001100100111111100101110001111110";
        System.out.println(new TheHuffmanDecoder().decode(codes, encoded));
    }
}
