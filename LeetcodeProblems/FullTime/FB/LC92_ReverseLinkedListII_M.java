package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC92_ReverseLinkedListII_M {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        int i = 1;
        while (cur != null) {
            if (i == m) {
                ListNode last = cur;
                while (i <= n) {
                    ListNode tmp = cur.next;
                    cur.next = prev.next;
                    prev.next = cur;
                    cur = tmp;
                    i++;
                }
                last.next = cur;
                return dummy.next;
            } else {
                prev = cur;
                cur = cur.next;
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = new LC92_ReverseLinkedListII_M().reverseBetween(n1, 1,3);
        System.out.println(res.val);
    }

}
