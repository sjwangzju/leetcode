package LinkedList;

/**
 * Created by sjwang on 22/04/2018.
 * Given a singly linked list, determine if it is a palindrome.
 */

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode P = head;
        ListNode last = null;
        while(P != null){
            ListNode cur = new ListNode(P.val);
            cur.next = last;
            P = P.next;
            last = cur;
        }
        while(head != null){
            if(head.val != last.val) return false;
            head = head.next;
            last = last.next;
        }
        return true;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        System.out.println(new PalindromeLinkedList().isPalindrome(l3));
    }
}
