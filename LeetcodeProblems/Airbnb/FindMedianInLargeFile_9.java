package Airbnb;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianInLargeFile_9 {

    public Queue<Integer> large = new PriorityQueue<>();
    public Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void addNum(int n) {
        if (small.isEmpty() || small.peek() >= n) {
            small.offer(n);
        } else {
            large.offer(n);
        }

        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        }
        if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        if (small.size() > large.size()) {
            return small.peek();
        }
        return large.peek();
    }

    public static void main (String[] args) {
        FindMedianInLargeFile_9 find = new FindMedianInLargeFile_9();
        find.addNum(1);
        find.addNum(2);
        find.addNum(3);
        System.out.println(find.findMedian());
    }
}
