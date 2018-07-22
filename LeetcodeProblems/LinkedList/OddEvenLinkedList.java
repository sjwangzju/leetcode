package LinkedList;

/**
 * Created by sjwang on 07/22/2018.
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head, O = new ListNode(0), E = new ListNode(0), cur_O = O, cur_E = E;
        int i = 1;
        while(cur != null){
            if((i++) % 2 == 1){
                cur_O.next = cur;
                cur = cur.next;
                cur_O = cur_O.next;
                cur_O.next = null;
            }
            else{
                cur_E.next = cur;
                cur = cur.next;
                cur_E = cur_E.next;
                cur_E.next = null;
            }
        }
        cur_O.next = E.next;
        return O.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2= new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        System.out.println(new OddEvenLinkedList().oddEvenList(l1));
    }
}
