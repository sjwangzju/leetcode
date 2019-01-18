package VMware;

import java.util.HashMap;
import java.util.Map;

public class UsernamesSystem {
    public String[] usernamesSystem(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
            } else {
                map.put(names[i], map.get(names[i]) + 1);
                names[i] = names[i] + String.valueOf(map.get(names[i]) - 1);
            }
        }
        return names;
    }

    public static void main(String[] args) {
        String[] names = {"bob","alice","bob","alice","alice","bob","tom"};
        String[] res = new UsernamesSystem().usernamesSystem(names);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
