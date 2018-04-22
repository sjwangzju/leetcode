package LinkedList;

public class DeleteNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        new DeleteNodeInLinkedList().deleteNode(l2);
    }

}
