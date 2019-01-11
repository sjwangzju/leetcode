package FB;

import java.util.PriorityQueue;

public class LC23MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list: lists) {
            if (list != null) pq.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next != null) {
                pq.offer(tmp.next);
            }
        }
        return dummy.next;
    }
}
