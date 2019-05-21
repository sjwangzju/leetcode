package Indeed;


// Given a LinkedList, every node contains a array. Every element of the array is char implement two functions
// 1. get(int index) find the char at the index
// 2. insert(char ch, int index) insert the char to the index

public class UnrolledLinkedList {

//    private int size;
//    private int totalLen;
//    private Node head;
//
//    public class Node {
//        char[] array;
//        Node next;
//        int len;
//
//        public Node() {
//            this.array = new char[size];
//            this.next = null;
//            this.len = 0;
//        }
//    }
//
//    public UnrolledLinkedList() {
//        this.head = null;
//        this.size = 2;
//        this.totalLen = 0;
//    }
//
//
//    public Character get(int index) {
//        if (index < 0 || index >= totalLen) return null;
//
//        Node cur = head;
//
//        while (cur != null) {
//            if (index >= cur.len) {
//                index -= cur.len;
//            } else {
//                return cur.array[index];
//            }
//            cur = cur.next;
//        }
//        return null;
//    }
//
//    public void insert(int index, char c) {
//        if (index < 0 || index > totalLen) return;
//
//        Node cur = head;
//        Node prev = new Node();
//        prev.next = head;
//
//        while (cur != null) {
//            if (index >= size) {
//                index -= size;
//            } else {
//                // cur array is full
//                if (cur.len == size) {
//                    Node newNode = new Node();
//                    newNode.array[0] = cur.array[size - 1];
//                    newNode.len = 1;
//                    newNode.next = cur.next;
//                    cur.next = newNode;
//                    cur.len--;
//                }
//
//                for (int i = cur.len; i >= index + 1; i--) {
//                    cur.array[i] = cur.array[i - 1];
//                }
//                cur.array[index] = c;
//                cur.len++;
//                break;
//            }
//
//            prev = cur;
//            cur = cur.next;
//        }
//
//        // list is null or should insert to the last element
//        if (cur == null) {
//            Node newNode = new Node();
//            newNode.array[0] = c;
//            newNode.len = 1;
//            prev.next = newNode;
//
//            // list is null
//            if (head == null) {
//                head = prev.next;
//            }
//        }
//        totalLen++;
//    }
//
//
//    public void delete(int index) {
//        if (index < 0 || index >= totalLen) return;
//
//        Node prev = new Node();
//        prev.next = head;
//        Node cur = head;
//
//        while (cur != null) {
//            if (index >= cur.len) {
//                index -= cur.len;
//            } else {
//                // delete the cur node
//                if (cur.len == 1) {
//                    prev.next = cur.next;
//                    if (head == cur) {
//                        head = prev.next;
//                    }
//                } else {
//                    for (int i = index; i < cur.len - 1; i++) {
//                        cur.array[i] = cur.array[i + 1];
//                    }
//                    cur.len--;
//                }
//                break;
//            }
//
//            prev = cur;
//            cur = cur.next;
//        }
//
//        totalLen--;
//    }

    public static class UnrolledList {

        int size;
        int totalLen;
        Node head;

        public UnrolledList() {
            this.size = 2;
            this.totalLen = 0;
            this.head = null;
        }

        public class Node {
            char[] array;
            int len;
            Node next;

            public Node() {
                this.array = new char[size];
                this.len = 0;
                this.next = null;
            }
        }

        public void insert(int index, char ch) {
            if (index < 0 || index > totalLen) return;

            Node cur = head;
            Node prev = new Node();
            prev.next = cur;

            while (cur != null) {
                if (index >= cur.len) {
                    index -= cur.len;
                    prev = cur;
                    cur = cur.next;
                    continue;
                }

                if (cur.len == size) {
                    Node newNode = new Node();
                    newNode.array[0] = cur.array[size - 1];
                    newNode.len = 1;
                    newNode.next = cur.next;
                    cur.next = newNode;
                    cur.len--;
                }


                for (int i = cur.len; i >= index + 1; i--) {
                    cur.array[i] = cur.array[i - 1];
                }
                cur.array[index] = ch;
                cur.len++;
            }

            if (cur == null) {
                Node newNode = new Node();
                newNode.array[0] = ch;
                newNode.len = 1;
                cur = newNode;
                prev.next = cur;
                if (head == null) {
                    head = prev.next;
                }
            }
            totalLen++;
        }


        public Character get(int index) {
            if (index < 0 || index >= totalLen) return null;

            Node cur = head;
            while (cur != null) {
                if (index >= cur.len) {
                    index -= cur.len;
                    cur = cur.next;
                    continue;
                }
                return cur.array[index];
            }
            return null;
        }
    }


    public static void main(String[] args) {
//        UnrolledLinkedList list = new UnrolledLinkedList();
        UnrolledList list = new UnrolledList();
        list.insert(0, 'a');
        list.insert(1, 'b');
        list.insert(2, 'c');
        list.insert(3, 'd');
        list.insert(4, 'e');

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

//        list.delete(4);
//        list.delete(2);
//        list.delete(2);
//        list.delete(1);

//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
    }
}
