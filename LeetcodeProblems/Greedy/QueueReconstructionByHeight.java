package Greedy;

import java.util.*;

/**
 * Created by sjwang on 08/12/2018.
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        for(int[] i : people) {
            Q.offer(i);
        }
        List<int[]> L = new LinkedList<>();
        while(!Q.isEmpty()) {
            int[] temp = Q.poll();
            L.add(temp[1], temp);
        }
        int[][] re = new int[people.length][2];
        for(int i = 0; i < L.size(); i++) {
            re[i] = L.get(i);
        }
        return re;
    }

    public static void main(String args[]){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(new QueueReconstructionByHeight().reconstructQueue(people));
    }
}
