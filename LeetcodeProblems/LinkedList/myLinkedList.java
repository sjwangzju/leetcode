package LinkedList;

public class myLinkedList {

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // the first node in the linkedList, is a dummy node
    private Node head;

    private myLinkedList() {
        this.head = new Node(-1);
    }

    /**
     * Insert a Node with value n into the linkedList
     *
     * time: O(N)
     *
     * @param n
     */
    public void insert(int n) {
        Node newNode = new Node(n);
        Node cur = head;

        while (cur.next != null && n > cur.next.val) {
            cur = cur.next;
        }

        newNode.next = cur.next;
        cur.next = newNode;
    }


    /**
     * Delete a Node with value n from the linkedList
     *
     * time: O(N)
     *
     * @param n
     */
    private void delete(int n) {
        Node cur = head;

        while (cur.next != null) {
            if (cur.next.val == n) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }


    /**
     * print out the linkedList
     */
    private void print() {
        Node cur = head;

        while (cur.next != null) {
            System.out.print(cur.next.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        myLinkedList ls = new myLinkedList();

        System.out.println("insert");
        ls.insert(5);
        ls.print();
        ls.insert(-1);
        ls.print();
        ls.insert(2);
        ls.print();
        ls.insert(10);
        ls.print();
        ls.insert(-5);
        ls.print();

        System.out.println("\ndelete");
        ls.delete(2);
        ls.print();
        ls.delete(-1);
        ls.print();
        ls.delete(5);
        ls.print();
        ls.delete(-5);
        ls.print();
        ls.delete(10);
        ls.print();

    }
}
