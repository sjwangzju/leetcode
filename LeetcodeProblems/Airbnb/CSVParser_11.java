package Airbnb;

import java.util.LinkedList;
import java.util.List;

public class CSVParser_11 {
    public String CSVParser(String input) {
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if (inQuote) {
                if (input.charAt(i) == '\"') {
                    if (i + 1 < input.length() && input.charAt(i + 1) == '\"') {
                        sb.append('\"');
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(input.charAt(i));
                }
            } else {
                if (input.charAt(i) == '\"') {
                    inQuote = true;
                } else if (input.charAt(i) == ',') {
                    res.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(input.charAt(i));
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return String.join("|", res);
    }

    public static void main(String[] args) {
        String s1 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        System.out.println(new CSVParser_11().CSVParser(s1));

        String s2 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        System.out.println(new CSVParser_11().CSVParser(s2));

        String s3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1 \"\"\"Alexandra Alex\"\"\"";
        System.out.println(new CSVParser_11().CSVParser(s3));
    }
}
