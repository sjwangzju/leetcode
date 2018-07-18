package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/18/2018.
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * Example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class FindMedianFromDataStream {
    public static class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        public void addNum(int num) {
            if(small.size() == 0 || num <= small.peek()) small.offer(num);
            else large.offer(num);

            if(small.size() - large.size() > 1) large.offer(small.poll());
            if(large.size() - small.size() > 1) small.offer(large.poll());
        }

        public double findMedian() {
            if(small.size() == large.size()) return (small.peek() + large.peek()) / 2.0;
            else if(small.size() > large.size()) return small.peek();
            else return large.peek();
        }
    }
    public static void main(String args[]){
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        mf.addNum(-2);
        mf.addNum(-3);
        System.out.println(mf.findMedian());
    }
}
