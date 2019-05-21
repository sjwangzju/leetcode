package Indeed;


//Given a stream of input, and a API int getNow() to get the current time stamp
//1). void record(int val) to save the record.
//2). double getAvg() to calculate the averaged value of all the records in 5 minutes
//follow up
//3). 5分钟内数据太多了了怎么办。
//4). 如果算中位数呢? 分两种, ⼀一个是调⽤用不不多( quick sort) 另外⼀一个 调的频繁(两个heap维
//护⼀一下)

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MovingAverage {

    public static class Node {
        int timestamp;
        int val;

        public Node(int timestamp, int val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    // time: worst O(N), N is the total num of records
    // space: O(N)
    public static class MovingAvgI{
        public LinkedList<Node> q;
        public int sum;
        public int timeWindow;

        public MovingAvgI(int timeWindow) {
            this.q = new LinkedList<>();
            this.sum = 0;
            this.timeWindow = timeWindow;
        }

        // time: O(logN)
        public void record(int timestamp, int val) {
            Node n = new Node(timestamp, val);
            q.offer(n);
            sum += n.val;
            update(timestamp);
        }

        // time: O(MlogN)
        public double getAvg(int timestamp) {
            update(timestamp);
            return sum / q.size();
        }

        public void update(int timestamp) {
            while (!q.isEmpty() && timestamp - q.peek().timestamp >= timeWindow) {
                Node tmp = q.poll();
                sum -= tmp.val;
            }
        }

//        public double getMedian(int timestamp) {
//            update(timestamp);
//            int n = q.size();
//            if (n % 2 == 1) {
//                return findKth(q, 0, n - 1, n / 2);
//            }
//            return (findKth(q, 0, n - 1, n / 2) + findKth(q, 0, n - 1, n / 2 - 1)) / 2.0;
//        }
//
//        // find median using quick select when not called frequently
//        // time: worst O(N^2), average O(N)
//        public int findKth(LinkedList<Node> q, int lo, int hi, int k) {
//            int lb = lo;
//            int hb = hi;
//            int cur = lo + 1;
//            int pivot = q.get(lo).val;
//
//            while (cur <= hb) {
//                if (q.get(cur).val < pivot) {
//                    swap(q, lb++, cur++);
//                } else if (q.get(cur).val > pivot) {
//                    swap(q, cur, hb--);
//                } else {
//                    cur++;
//                }
//            }
//
//            if (k < lb) {
//                return findKth(q, lo, lb - 1, k);
//            } else if (k > hb) {
//                return findKth(q, hb + 1, hi, k);
//            }
//            return pivot;
//        }
//
//        public void swap(LinkedList<Node> q, int i, int j) {
//            int tmp = q.get(i).val;
//            q.get(i).val = q.get(j).val;
//            q.get(j).val = tmp;
//        }


        public double getMedian(int timestamp) {
            update(timestamp);

            int size = q.size();
            if (size % 2 == 1) {
                return getKth(q, 0, size - 1, size / 2);
            }
            return (getKth(q, 0, size - 1, size / 2) + getKth(q, 0, size - 1, size / 2 - 1)) / 2.0;
        }

        public int getKth(LinkedList<Node> q, int lo, int hi, int k) {
            int lb = lo;
            int hb = hi;
            int cur = lo + 1;
            int pivot = q.get(lo).val;

            while (cur <= hb) {
                if (q.get(cur).val < pivot) {
                    swap(q, lb++, cur++);
                } else if (q.get(cur).val > pivot) {
                    swap(q, cur, hb--);
                } else {
                    cur++;
                }
            }

            if (k < lb) return getKth(q, lo, lb - 1, k);
            if (k > hb) return getKth(q, hb + 1, hi, k);
            return pivot;
        }

        public void swap(LinkedList<Node> q, int i, int j) {
            int tmp = q.get(i).val;
            q.get(i).val = q.get(j).val;
            q.get(j).val = tmp;
        }

    }


    // when get median is called frequently, using two heaps (min + max)
    public static class MovingAvgII {
        PriorityQueue<Node> minHeap;
        PriorityQueue<Node> maxHeap;
        int timeWindow;
        int sum;

        public MovingAvgII(int timeWindow) {
            this.minHeap = new PriorityQueue<>((a,b) -> (a.timestamp - b.timestamp));
            this.maxHeap = new PriorityQueue<>((a,b) -> (b.timestamp - a.timestamp));
            this.timeWindow = timeWindow;
            this.sum = 0;
        }

        // time: O(logN)
        public void record(int timestamp, int val) {
            Node n = new Node(timestamp, val);
            if (maxHeap.size() == 0 || timestamp < maxHeap.peek().timestamp) {
                maxHeap.offer(n);
            } else {
                minHeap.offer(n);
            }
            sum += val;
            update(timestamp);
        }

        public void update(int timestamp) {
            while (!maxHeap.isEmpty() && timestamp - maxHeap.peek().timestamp >= timeWindow) {
                sum -= maxHeap.poll().val;
            }
            while (!minHeap.isEmpty() && timestamp - minHeap.peek().timestamp >= timeWindow) {
                sum -= minHeap.poll().val;
            }

            while (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
            while (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // time: O(MlogN)
        public double getAvg(int timestamp) {
            update(timestamp);

            return sum / (minHeap.size() + maxHeap.size());
        }


        // time: O(1)
        public double getMedian(int timestamp) {
            update(timestamp);

            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek().val + minHeap.peek().val) / 2.0;
            }
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek().val;
            }
            return minHeap.peek().val;
        }
    }


    public static void main(String[] args) {
//        MovingAvgII ma = new MovingAvgII(300);
        MovingAvgI ma = new MovingAvgI(300);
        ma.record(1, 10);
        ma.record(5,50);
        ma.record(10,100);
        System.out.println(ma.getAvg(300));
        System.out.println(ma.getMedian(300));
        System.out.println(ma.getAvg(301));
        System.out.println(ma.getMedian(301));
    }
}
