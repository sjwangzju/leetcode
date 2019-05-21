package Intuit;

import java.util.*;

public class Employee_6 {

    // String[] employees = {"1,Richard,Engineering", "2,Erlich,HR", "3,Monica,Business", "4,Dinesh,Engineering", "6,Carla,Engineering"};
    // String[] friendships = {"1,2","1,3","2,4"};
    public void Employees(String[] employees, String[] friendships) {

        // the list of friends for each employee
        Map<String, List<String>> friendlist = new HashMap<>();
        Map<String, List<String>> department = new HashMap<>();
        Set<String> employee = new HashSet<>();

        for (String e: employees) {
            String curE = e.split(",")[0];
            employee.add(curE);

            String curD = e.split(",")[2];
            if (!department.containsKey(curD)) {
                department.put(curD, new LinkedList<>());
            }
            department.get(curD).add(curE);
        }

        for (String friendship: friendships) {
            String e1 = friendship.split(",")[0];
            String e2 = friendship.split(",")[1];
            if (!friendlist.containsKey(e1)) {
                friendlist.put(e1, new LinkedList<>());
            }
            if (!friendlist.containsKey(e2)) {
                friendlist.put(e2, new LinkedList<>());
            }
            friendlist.get(e1).add(e2);
            friendlist.get(e2).add(e1);
        }

        /*************************************************************************************/

        // get friendlist for all employees
        for (String s: employee) {
            System.out.println(s + ": " + friendlist.get(s));
        }
        System.out.println();



        /*************************************************************************************/

        // get employees having friends from other departments
        // time: O(V + E)
        for (String s: department.keySet()) {
            List<String> e = department.get(s);
            Set<String> set = new HashSet<>();
            for (String f: e) {
                List<String> list = friendlist.getOrDefault(f, new LinkedList<>());
                for (String l: list) {
                    if (!e.contains(l)) {
                        set.add(f);
                    }
                }
            }
            System.out.println(s + " " + e + "->" + set);
        }

    }

    public static void main(String[] args) {
        String[] employees = {"1,Richard,Engineering","2,Erlich,HR","3,Monica,Business",
                "4,Dinesh,Engineering","6,Carla,Engineering"};
        String[] friendships = {"1,2","1,3","2,4"};
        new Employee_6().Employees(employees, friendships);
    }
}
