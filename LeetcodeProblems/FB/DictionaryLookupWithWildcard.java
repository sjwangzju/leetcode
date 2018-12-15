package FB;

import java.util.*;

public class DictionaryLookupWithWildcard {

    public Map<Integer, List<String>> dict = new HashMap<>();

    public void setup(List<String> input) {
        for (String s: input) {
            int len = s.length();
            List<String> tmp = dict.getOrDefault(len, new LinkedList<>());
            tmp.add(s);
            dict.put(len, tmp);
        }
    }

    public boolean isMember(String str) {
        int len = str.length();
        if (!dict.containsKey(len)) {
            return false;
        }
        List<String> list = dict.get(len);

        for(String s: list) {
            int cnt = 0;
            for(int i = 0; i < len; i++) {
                if (s.charAt(i) == str.charAt(i) || str.charAt(i) == '.') {
                    cnt++;
                }
            }
            if (cnt == len) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("foo", "bar", "baz"));
        DictionaryLookupWithWildcard LookUp = new DictionaryLookupWithWildcard();
        LookUp.setup(input);
        System.out.println(LookUp.isMember("foo"));
        System.out.println(LookUp.isMember("f.o"));
        System.out.println(LookUp.isMember("..d"));
    }
}
