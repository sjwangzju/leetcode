package Indeed;

import java.util.*;

//  Given n sorted stream, and a constant number k. The stream type is like iterator
//  and it has two functions, move() and getValue(), find a list of numbers that each
//  of them appears at least k times in these streams. Duplicate numbers in a stream
//  should be counted as once.

public class MergeKSortedStreams {

//    public static class Stream {
//        Iterator<Integer> iterator;
//
//        public Stream(List<Integer> list) {
//            this.iterator = list.iterator();
//        }
//
//        public boolean move() {
//            return iterator.hasNext();
//        }
//
//        public int getValue() {
//            return iterator.next();
//        }
//    }

//    public static class Node{
//        int val;
//        Stream stream;
//
//        public Node(Stream stream) {
//            this.stream = stream;
//            this.val = stream.getValue();
//        }
//    }
//
//
//    // time: O(NlogN), N is the num of all streams
//    public List<Integer> find(List<Stream> streams, int k) {
//        List<Integer> res = new LinkedList<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
//
//        for (Stream stream: streams) {
//            if (stream.move()) {
//                pq.offer(new Node(stream));
//            }
//        }
//
//        while (!pq.isEmpty()) {
//            // break in advance
//            if (pq.size() < k) break;
//
//            Node cur = pq.poll();
//            int curVal = cur.val;
//            int cnt = 1;
//
//            while (cur.stream.move()) {
//                int next = cur.stream.getValue();
//                if (next == curVal) continue;
//                cur.val = next;
//                pq.offer(cur);
//                break;
//            }
//
//            while (!pq.isEmpty() && pq.peek().val == curVal) {
//                Node n = pq.poll();
//                while (n.stream.move()) {
//                    int next = n.stream.getValue();
//                    if (next == curVal) continue;
//                    n.val = next;
//                    pq.offer(n);
//                    break;
//                }
//                cnt++;
//            }
//
//            if (cnt >= k) {
//                res.add(curVal);
//            }
//        }
//        return res;
//    }


    public static class Stream {

        List<Integer> list;
        Iterator<Integer> iterator;

        public Stream(List<Integer> list) {
            this.list = list;
            this.iterator = list.iterator();
        }

        public boolean move() {
            return iterator.hasNext();
        }

        public Integer getVal() {
            return iterator.next();
        }
    }


    public static class Node {
        Stream stream;
        int val;

        public Node(Stream stream) {
            this.stream = stream;
            this.val = stream.getVal();
        }
    }

    public List<Integer> find(List<Stream> list, int k) {

        List<Integer> res = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (Stream stream: list) {
            if (stream.move()) {
                pq.offer(new Node(stream));
            }
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVal = cur.val;
            int cnt = 1;

            while (cur.stream.move()) {
                int nextVal = cur.stream.getVal();
                if (nextVal == curVal) {
                   continue;
                }
                cur.val = nextVal;
                pq.offer(cur);
                break;
            }

            while (!pq.isEmpty() && pq.peek().val == curVal) {
                cnt++;
                Node node = pq.poll();
                while (node.stream.move()) {
                    int nextVal = node.stream.getVal();
                    if (nextVal == curVal) {
                        continue;
                    }
                    node.val = nextVal;
                    pq.offer(node);
                    break;
                }
            }
            if (cnt >= k) {
                res.add(curVal);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,1,2,3,4,5);
        List<Integer> l2 = Arrays.asList(1,2,3,4,5);
        List<Integer> l3 = Arrays.asList(1,2,6,7);

        List<Stream> streams = new LinkedList<>();
        Stream s1 = new Stream(l1);
        Stream s2 = new Stream(l2);
        Stream s3 = new Stream(l3);
        streams.add(s1);
        streams.add(s2);
        streams.add(s3);

        System.out.println(new MergeKSortedStreams().find(streams, 3));
    }
}
