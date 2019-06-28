package FullTime.FB;

/**
 * Linked Node
 *
 * time: O(1)
 * space: O(k), k is the size of queue
 */
public class LC622_DesignCircularQueue_M {

    static class MyCircularQueue {

        class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

        int maxSize, curSize;
        Node head, cur;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.maxSize = k;
            this.curSize = 0;
            this.head = new Node(-1);
            Node tmp = head;
            for (int i = 0; i < k - 1; i++) {
                tmp.next = new Node(-1);
                tmp = tmp.next;
            }
            tmp.next = head;
            cur = tmp;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (curSize == maxSize) return false;
            cur = cur.next;
            cur.val = value;
            curSize++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (curSize == 0) {
                return false;
            }
            head = head.next;
            curSize--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return curSize == 0? -1: head.val;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return curSize == 0? -1: cur.val;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return curSize == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return curSize == maxSize;
        }
    }


    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(5));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(10));
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(9));
        System.out.println(obj.Front());
        System.out.println(obj.Rear());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isFull());
    }
}
