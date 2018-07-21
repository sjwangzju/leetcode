package LinkedList;

import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/21/2018.
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(head != null){
            pq.offer(head.val);
            head = head.next;
        }
        ListNode n = new ListNode(0), re = n;
        while(!pq.isEmpty()){
            ListNode N = new ListNode(pq.poll());
            n.next = N;
            n = n.next;
        }
        return re.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
