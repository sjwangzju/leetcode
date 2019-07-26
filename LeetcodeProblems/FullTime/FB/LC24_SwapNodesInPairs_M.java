package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC24_SwapNodesInPairs_M {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode res = new LC24_SwapNodesInPairs_M().swapPairs(l1);
        System.out.print(res.val);
    }
}
