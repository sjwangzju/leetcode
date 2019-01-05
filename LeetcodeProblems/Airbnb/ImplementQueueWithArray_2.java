package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueueWithArray_2 {

//    public static class ListNode {
//        private int maxSize;
//        private int cnt;
//        private int head;
//        private int tail;
//        private List<Object> headList;
//        private List<Object> tailList;
//
//        public ListNode(int maxSize) {
//            this.maxSize = maxSize;
//            this.cnt = 0;
//            this.head = 0;
//            this.tail = 0;
//            this.headList = new ArrayList<>();
//            this.tailList = this.headList;
//        }
//
//        public Integer pop() {
//            if (cnt == 0) {
//                return null;
//            }
//            int num = (int)headList.get(head);
//            cnt--;
//            head++;
//
//            if (head == maxSize - 1) {
//                List<Object> cur = (List<Object>)headList.get(head);
//                headList.clear();
//                headList = cur;
//                head = 0;
//            }
//            return num;
//        }
//
//        public void push(int n) {
//            if (tail == maxSize - 1) {
//                List<Object> curList = new ArrayList<>();
//                curList.add(n);
//                tailList.add(curList);
//                tailList = (List<Object>)tailList.get(tail);
//                tail = 0;
//            } else {
//                tailList.add(n);
//            }
//            cnt++;
//            tail++;
//        }
//    }
//
//    public static void main(String[] args) {
//        ListNode queue = new ImplementQueueWithArray_2.ListNode(3);
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        queue.push(5);
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//    }
    public static class myQueue {
        int size;
        int head;
        int tail;
        int len;
        Object[] headArray;
        Object[] tailArray;

        myQueue(int n) {
            this.size = n;
            this.head = 0;
            this.len = 0;
            this.tail = this.head;
            this.headArray = new Object[this.size];
            this.tailArray = new Object[this.size];
        }

        public void push(int num) {
            if (tail == size - 1) {
                tailArray[tail] = new Object[this.size];
                tailArray = (Object[])tailArray[tail];
                tail = 0;
            }
            tailArray[tail] = num;
            tail++;
            len++;
            return;
        }


        public Integer pop() {
            if (this.len == 0) return null;
            if (head == this.size - 1) {
                headArray = (Object[])headArray[head];
                head = 0;
            }
            int res = (int)headArray[head];
            head++;
            len--;
            return res;
        }
    }

    public static void main(String[] args) {
        myQueue q = new myQueue(3);
        q.push(1);
        q.push(2);
        System.out.println(q.pop());
    }

}
