package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjwang on 07/19/2018.
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    public static class MovingAverage {
        Queue<Integer> q = new LinkedList<>();
        int window; double sum;

        public MovingAverage(int size) {
            window = size;
        }
        public double next(int val) {
            if(q.size() < window){
                q.offer(val);
                sum += val;
                return sum / q.size();
            }
            else{
                sum -= q.poll();
                sum += val;
                q.offer(val);
                return sum / window;
            }
        }
    }
    public static void main(String args[]){
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
