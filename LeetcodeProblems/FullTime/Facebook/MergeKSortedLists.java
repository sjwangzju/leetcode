package FullTime.Facebook;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Merge k sorted linked lists and return it as one sorted list.
    //
    // Input:
    // [
    //  1->4->5,
    //  1->3->4,
    //  2->6
    // ]
    // Output: 1->1->2->3->4->4->5->6
    //
    // Solution1: pq
    // time: O(NKlogK), N is avg num of nodes in a list
    // space: O(K)
    /*******************************************************************************/
    public ListNode mergeKListsI(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
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


    // Solution2: Divide and conquer
    // time: O(NKlogK)
    // space: O(logK), recursion stack
    /*******************************************************************************/
    public ListNode mergeKListsII(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l = merge(lists, lo, mid);
        ListNode r = merge(lists, mid + 1, hi);
        return mergeTwoLists(l, r);
    }

    public ListNode mergeTwoLists(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return dummy.next;
    }
}
