package Airbnb;

import java.util.*;

public class SimulateDiplomacy_16 {
    public List<String> battle(List<String> actions) {
        Map<String, List<String>> location = new HashMap<>();
        Map<String, Integer> strength = new HashMap<>();
        Map<String, String> result = new HashMap<>();

        for (String action: actions) {
            String[] strs = action.split(" ");
            String army1 = strs[0];
            String newLocation = strs.length == 3 ? strs[1] : strs[2].equals("Move") ? strs[3] : strs[1];

            // update the location of each army
            List<String> loc = location.getOrDefault(newLocation, new LinkedList<>());
            loc.add(army1);
            location.put(newLocation, loc);

            // initialize the strength of each army as 1
            strength.put(army1, 1);
        }

        for (String action: actions) {
            String[] strs = action.split(" ");
            if (strs.length == 4 && strs[2].equals("Support")) {
                String pos = strs[1];
                String supportee = strs[3];
                if (location.get(pos).size() == 1) {
                    // update the strength map
                    strength.put(supportee, strength.get(supportee) + 1);
                }
            }
        }

        // get result of the battle
        for (String loc: location.keySet()) {
            List<String> armies = location.get(loc);
            if (armies.size() == 1) {
                result.put(armies.get(0), loc);
            } else {
                int cnt = 0;
                int max = strength.get(armies.get(0));
                String winner = armies.get(0);
                for (int i = 0; i < armies.size(); i++) {
                    String curArmy = armies.get(i);
                    result.put(curArmy, "[dead]");
                    if (strength.get(curArmy) > max) {
                        max = strength.get(curArmy);
                        winner = curArmy;
                        cnt = 0;
                    } else if (strength.get(curArmy) == max) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    result.put(winner, loc);
                }
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<String> ret = new LinkedList<>();
        for (String s: result.keySet()) {
            String tmp = s + " " + result.get(s);
            pq.offer(tmp);
        }
        while(!pq.isEmpty()) {
            ret.add(pq.poll());
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> actions = new LinkedList<>();
        actions.add("B Bohemia Move Prussia");
        actions.add("A Munich Support B");
        actions.add("D Warsaw Move Munich");
        actions.add("C Prussia Hold");

//        actions.add("A Munich Hold");
//        actions.add("B Bohemia Move Munich");
//        actions.add("D Warsaw Hold");
//        actions.add("C Prussia Move Munich");

        List<String> ret = new SimulateDiplomacy_16().battle(actions);
        for (String s: ret) {
            System.out.println(s);
        }
    }
}
