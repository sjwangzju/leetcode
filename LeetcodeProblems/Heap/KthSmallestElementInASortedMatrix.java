package Heap;

import java.util.Arrays;

/**
 * Created by sjwang on 07/15/2018.
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix[0].length * matrix.length];
        int m = 0;
        for(int i = 0; i < matrix[0].length; i ++){
            for(int j = 0; j < matrix.length; j ++){
                arr[m++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
    public static void main(String args[]){
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, 8));
    }
}
