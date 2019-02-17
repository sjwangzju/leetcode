package Amazon;

import java.util.List;

public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * time: O(N), space: O(N)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode pt1 = dummyHead1;
        ListNode pt2 = dummyHead2;

        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (tmp.val < x) {
                pt1.next = tmp;
                pt1 = pt1.next;

            } else {
                pt2.next = tmp;
                pt2 = pt2.next;
            }
            head = head.next;
        }
        pt1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode res = new PartitionList().partition(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
