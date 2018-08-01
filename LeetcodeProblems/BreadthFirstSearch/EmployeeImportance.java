package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 *
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of
 * this employee and all his subordinates.
 *
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
 * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * Note:
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> M = new HashMap<>();
        for(Employee e : employees) {
            M.put(e.id, e);
        }
        int sum = 0;
        Queue<Employee> Q = new LinkedList<>();
        Q.offer(M.get(id));
        while(!Q.isEmpty()) {
            Employee cur = Q.poll();
            sum += cur.importance;
            if(cur.subordinates != null) {
                for(int i : cur.subordinates) Q.offer(M.get(i));
            }
        }
        return sum;
    }
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public static void main(String args[]){
        Employee e1 = new Employee();
        e1.id = 1; e1.subordinates = new ArrayList<>(Arrays.asList(2,3)); e1.importance = 5;
        Employee e2 = new Employee();
        e2.id = 2; e2.subordinates = null; e2.importance = 3;
        Employee e3 = new Employee();
        e3.id = 3; e3.subordinates = null; e3.importance = 3;
        List<Employee> L = new ArrayList<>(Arrays.asList(e1,e2,e3));
        System.out.println(new EmployeeImportance().getImportance(L, 1));
    }
}
