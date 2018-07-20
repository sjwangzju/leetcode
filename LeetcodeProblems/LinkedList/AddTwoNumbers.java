package LinkedList;

/**
 * Created by sjwang on 07/20/2018.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(0), N = null, t = re;
        int num, add = 0;
        while(l1 != null && l2 != null){
            num = l1.val + l2.val + add;
            add = 0;
            if(num >= 10){
                num -= 10;
                add = 1;
            }
            t.next = new ListNode(num);
            t = t.next;
            l1 = l1.next; l2 = l2.next;
        }
        if(l1 != null){
            N = l1;
        }
        else if(l2 != null) N = l2;

        while(N != null){
            num = N.val + add;
            add = 0;
            if(num >= 10){
                num -= 10;
                add = 1;
            }
            t.next = new ListNode(num);
            t = t.next;
            N = N.next;
        }
        if(add == 1){
            t.next = new ListNode(1);
            t = t.next;
        }

        return re.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
