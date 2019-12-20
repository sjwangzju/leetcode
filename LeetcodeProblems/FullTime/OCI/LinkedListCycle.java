package FullTime.OCI;

public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Linked List Cycle I
     * Given a linked list, determine if it has a cycle in it.
     *
     * Solution:
     * 1. slow (1 step) & fast (2 steps) pointers
     * 2. fast pointer will meet slow pointer at a position in the cycle
     *
     * time: O(N), space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }


    /**
     * Linked List Cycle II
     * Given a linked list, return the node where the cycle begins.
     * If there is no cycle, return null.
     *
     * Solution:
     * 1. use Linked List Cycle I to find the intersection node
     * 2. 2*(d + a) = (d + 2a + b)
     *    d = b
     * 3. tmp and intersect node move one step together, will eventually meet at the entrance of cycle
     *
     * time: O(N), space: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode intersect = findIntersection(head);
        ListNode tmp = head;
        if (intersect == null) return null;
        while (!intersect.equals(tmp)) {
            intersect = intersect.next;
            tmp = tmp.next;
        }
        return tmp;
    }

    // find the intersection node
    public ListNode findIntersection(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return slow;
        }
        return null;
    }
}
