public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) return false;
        while (fast != null && slow != null) {
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }return false;
    }
}