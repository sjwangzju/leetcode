package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 08/07/2018.
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int add = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + add);
            }
        }
        return triangle.get(0).get(0);
    }
    public static void main(String args[]){
        List<List<Integer>> L = new ArrayList<>();
        L.add(0, new ArrayList<>(Arrays.asList(2)));
        L.add(1, new ArrayList<>(Arrays.asList(3,4)));
        L.add(2, new ArrayList<>(Arrays.asList(6,5,7)));
        L.add(3, new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(new Triangle().minimumTotal(L));
    }
}
