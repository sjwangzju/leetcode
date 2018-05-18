package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 05/15/2018.
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i = 0; i < numRows; i ++){
            if(i == 0){
                ArrayList<Integer> A = new ArrayList<>();
                A.add(1);
                L.add(A);
            }
            else if(i == 1){
                ArrayList<Integer> A = new ArrayList<>();
                A.add(1); A.add(1);
                L.add(A);
            }
            else{
                ArrayList<Integer> A = new ArrayList<>();
                A.add(1);
                for(int j = 1; j < i; j ++){
                    A.add(L.get(i - 1).get(j - 1) + L.get(i - 1).get(j));
                }
                A.add(1);
                L.add(A);
            }
        }
        return (List) L;
    }

    public static void main(String args[]){
        System.out.println(new PascalsTriangle().generate(5));
    }
}
