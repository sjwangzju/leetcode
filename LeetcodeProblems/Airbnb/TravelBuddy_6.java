package Airbnb;

import java.util.*;

/**
 * A.retainAll(B) -- get the intersection of A and B
 * A.removeAll(B) -- get the element that belongs to A but not B
 */

public class TravelBuddy_6 {

//    List<Buddy> res = new LinkedList<>();
//    Set<String> myCities = new HashSet<>();
//
//    public List<Buddy> findTravelBuddy(Set<String> myCities, Map<String, Set<String>> buddies) {
//         this.myCities = myCities;
//
//         for (String k: buddies.keySet()) {
//             Set<String> buddyCities = buddies.get(k);
//             Set<String> tmp = new HashSet<>(buddyCities);
//             tmp.retainAll(myCities);
//             double similarity = (double)tmp.size() / buddyCities.size();
//
//             if (similarity >= 0.5) {
//                 Buddy newBuddy = new Buddy(similarity, k, buddyCities);
//                 res.add(newBuddy);
//             }
//         }
//
//         Collections.sort(res);
//         return res;
//    }
//
//    // follow up
//    public List<String> recommendCities(int max) {
//        List<String> recommend = new LinkedList<>();
//        for (Buddy b: res) {
//            b.cities.removeAll(myCities);
//            int cur = b.cities.size();
//            if (max >= cur) {
//                max -= cur;
//                for (String city: b.cities) {
//                    recommend.add(city);
//                }
//            } else {
//                for (String city: b.cities) {
//                    if (max > 0) {
//                        recommend.add(city);
//                        max--;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return recommend;
//    }

//    public class Buddy implements Comparable<Buddy> {
//        private double similarity;
//        private String name;
//        private Set<String> cities;
//
//        public Buddy(double similarity, String name, Set<String> cities) {
//            this.similarity = similarity;
//            this.name = name;
//            this.cities = cities;
//        }
//
//        @Override
//        public int compareTo(Buddy that) {
//            return Double.compare(that.similarity, this.similarity);
//        }
//    }

    public static class Buddy{
        String name;
        Set<String> cities;
        double similarity;

        public Buddy(String name, Set<String> cities, double similarity){
            this.name = name;
            this.cities = cities;
            this.similarity = similarity;
        }
    }

    public static List<Buddy> res = new LinkedList<>();
    public static Set<String> myCity = new HashSet<>();

    public static List<Buddy> findBuddies(Set<String> myCities,
                                          Map<String, Set<String>> myBuddies) {

        myCity = myCities;

        for (String buddy: myBuddies.keySet()) {
            Set<String> buddyCities = myBuddies.get(buddy);
            Set<String> tmp = new HashSet<>(myCities);
            tmp.retainAll(buddyCities);
            double sim = (double)tmp.size() / myCities.size();
            if (sim >= 0.5) {
                res.add(new Buddy(buddy, buddyCities, sim));
            }
        }

        Collections.sort(res, (a,b) -> Double.compare(b.similarity, a.similarity));

        return res;
    }


    public static List<String> getRecommendCities(int max) {
        List<String> recommend = new LinkedList<>();
        int cnt = 0;
        for (Buddy b: res) {
//            Set<String> buddyCities = b.cities;
            // Set<String> tmp = new HashSet<>(buddyCities);
            b.cities.removeAll(myCity);
            for (String s: b.cities) {
                if (cnt < max) {
                    recommend.add(s);
                    cnt++;
                } else {
                    return recommend;
                }
            }
        }
        return recommend;
    }

    public static void main(String[] args) {
        Set<String> myCities = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        Map<String, Set<String>> buddies = new HashMap<>();
        Set<String> buddy1Cities = new HashSet<>(Arrays.asList("a", "c", "d", "f"));
        Set<String> buddy2Cities = new HashSet<>(Arrays.asList("a", "c", "d", "b"));
        Set<String> buddy3Cities = new HashSet<>(Arrays.asList("d", "q", "y", "a"));
        buddies.put("buddy1", buddy1Cities);
        buddies.put("buddy2", buddy2Cities);
        buddies.put("buddy3", buddy3Cities);

        TravelBuddy_6 t = new TravelBuddy_6();
        List<Buddy> ret = t.findBuddies(myCities, buddies);
        for (Buddy b: ret) {
            System.out.println(b.name + " " + b.similarity);
        }

        List<String> recommend = t.getRecommendCities(2);
        for (String rec: recommend) {
            System.out.println(rec);
        }
    }
}
