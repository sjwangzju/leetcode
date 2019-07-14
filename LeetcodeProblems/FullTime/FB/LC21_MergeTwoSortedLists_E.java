package FullTime.FB;

public class LC21_MergeTwoSortedLists_E {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Solution1: Iteration
    // time: O(M+N)
    // space: O(1)
    public ListNode mergeTwoListsI(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null? l2: l1;
        return dummy.next;
    }

    // Solution2: Recursion
    // time: O(M+N)
    // space: O(M+N)
    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsII(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoListsII(l1, l2.next);
        return l2;
    }
}
