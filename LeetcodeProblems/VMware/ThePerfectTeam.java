package VMware;

import java.util.HashMap;
import java.util.Map;

public class ThePerfectTeam {
    public int differentTeams(String skills) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = skills.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.keySet().size() < 5) return 0;
        int min = Integer.MAX_VALUE;
        for (char n: map.keySet()) {
            min = Math.min(min, map.get(n));
        }
        return min;
    }

    public static void main(String[] args) {
        String skills = "pcmbzpcmb";
        System.out.println(new ThePerfectTeam().differentTeams(skills));
    }
}
