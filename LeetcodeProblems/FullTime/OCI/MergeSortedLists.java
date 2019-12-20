package FullTime.OCI;

import FullTime.FB.LC24_SwapNodesInPairs_M;

import java.util.PriorityQueue;

public class MergeSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * merge two sorted lists
     *
     * Iterative
     * time: O(M+N), space: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return res.next;
    }


    /**
     * Merge k sorted lists.
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     *
     * Solution1: divide and conquer (merge sort)
     *
     * time: O(NKlogK), N is num of lists
     * space: O(logK)
     *
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }


    /**
     * Solution2: pq
     * time: O(NKlogK), space: O(K)
     */
    public ListNode mergeKListsII(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
        for (ListNode n: lists) {
            if (n != null) pq.offer(n);
        }

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
