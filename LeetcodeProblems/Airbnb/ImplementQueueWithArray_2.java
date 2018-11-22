package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueueWithArray_2 {

    public static class ListNode {
        private int maxSize;
        private int cnt;
        private int head;
        private int tail;
        private List<Object> headList;
        private List<Object> tailList;

        public ListNode(int maxSize) {
            this.maxSize = maxSize;
            this.cnt = 0;
            this.head = 0;
            this.tail = 0;
            this.headList = new ArrayList<>();
            this.tailList = this.headList;
        }

        public Integer pop() {
            if (cnt == 0) {
                return null;
            }
            int num = (int)headList.get(head);
            cnt--;
            head++;

            if (head == maxSize - 1) {
                List<Object> cur = (List<Object>)headList.get(head);
                headList.clear();
                headList = cur;
                head = 0;
            }
            return num;
        }

        public void push(int n) {
            if (tail == maxSize - 1) {
                List<Object> curList = new ArrayList<>();
                curList.add(n);
                tailList.add(curList);
                tailList = (List<Object>)tailList.get(tail);
                tail = 0;
            } else {
                tailList.add(n);
            }
            cnt++;
            tail++;
        }
    }

    public static void main(String[] args) {
        ListNode queue = new ImplementQueueWithArray_2.ListNode(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
