package FullTime.FB;

/**
 * Two pointers
 *
 * time: O(l1 + l2)
 * space: O(max(l1, l2))
 */
public class LC2_AddTwoNumbers_M {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int add = 0;

        while (l1 != null || l2 != null) {
            int tmp = 0;
            tmp += add;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            add = tmp / 10;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
        }

        if (add == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        l11.next = l12; l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22; l22.next = l23;

        ListNode res = new LC2_AddTwoNumbers_M().addTwoNumbers(l11, l21);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
