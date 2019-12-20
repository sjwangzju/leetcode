package FullTime.Walmart;

public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // slow & fast pointers
    // time: O(N), space: O(1)
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
