package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 05/15/2018.
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i ++){
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
        return L.get(rowIndex);
    }

    public static void main(String args[]){
        System.out.println(new PascalsTriangleII().getRow(5));
    }
}
