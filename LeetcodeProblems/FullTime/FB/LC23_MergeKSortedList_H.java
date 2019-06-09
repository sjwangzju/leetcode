package FullTime.FB;

import java.util.PriorityQueue;

/**
 * Priority Queue of size K
 *
 * time: O(NlogK)
 * space: O(K)
 *
 */
public class LC23_MergeKSortedList_H {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode list: lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
            if (n.next != null) {
                pq.offer(n.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l11.next = l12; l12.next = l13;
        l21.next = l22; l22.next = l23;
        l31.next = l32;
        ListNode[] lists = new ListNode[]{l11, l21, l31};
        ListNode res = new LC23_MergeKSortedList_H().mergeKLists(lists);
        System.out.println(res.val);
    }
}
