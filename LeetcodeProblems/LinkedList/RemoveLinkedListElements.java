package LinkedList;

/**
 * Created by sjwang on 04/22/2018.
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElements {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Iteratively
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsIteratively(ListNode head, int val) {
        ListNode N = new ListNode(0);
        N.next = null;
        ListNode P = N;
        while(head != null){
            if(head.val != val){
                ListNode L = new ListNode(head.val);
                L.next = null;
                N.next = L;
                N = N.next;
            }
            head = head.next;
        }
        return P.next;
    }

    /**
     * Recursively
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursively(ListNode head, int val) {
        if(head == null) return null;
        while(head.val == val){
            if(head.next == null) return null;
            head = head.next;
        }
        head.next = removeElementsRecursively(head.next, val);
        return head;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        new RemoveLinkedListElements().removeElementsRecursively(l3, 2);
        new RemoveLinkedListElements().removeElementsIteratively(l3, 1);
    }

}
