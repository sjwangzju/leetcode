package LinkedList;

public class LinkedListCycle {

    static class ListNode {
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
        }
        return false;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l3;
        l2.next = l1;
        l3.next = l2;
        System.out.println(new LinkedListCycle().hasCycle(l3));
    }

}