package Sort;

/**
 * Created by sjwang on 08/16/2018.
 *
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode temp = head, re = null;
        while(temp != null) {
            int temp_val = temp.val;
            ListNode input = new ListNode(temp_val);
            if(re == null) re = input;
            else {
                if(temp_val < re.val) {
                    input.next = re;
                    re = input;
                }
                else {
                    ListNode n = re;
                    while(n != null) {
                        if(temp_val >= n.val) {
                            if(n.next != null && temp_val < n.next.val) {
                                ListNode l = n.next;
                                n.next = input;
                                n.next.next = l;
                            }
                            if(n.next == null) {
                                n.next = input;
                                n.next.next = null;
                            }
                        }
                        n = n.next;
                    }
                }
            }
            temp = temp.next;
        }
        return re;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String args[]){
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        System.out.println(new InsertionSortList().insertionSortList(n1));
    }
}
