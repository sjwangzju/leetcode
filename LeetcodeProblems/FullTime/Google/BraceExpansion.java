package FullTime.Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {

    // Brace ExpansionI
    // Solution: DFS
    /**********************************************/
    public String[] expand(String S) {
        List<String> res = new ArrayList<>();
        if (S.length() == 0) return new String[]{""};
        if (S.charAt(0) == '{') {
            int j = S.indexOf('}');
            String[] strs = S.substring(1, j).split(",");
            String[] next = expand(S.substring(j + 1));

            for (String str: strs) {
                for (String n: next) {
                    res.add(str + n);
                }
            }
        } else {
            String[] next = expand(S.substring(1));
            for (String n: next) {
                res.add(S.charAt(0) + n);
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }


}
