package FB;

import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {

    /**
     * double linked list
     *
     * time: O(1), space: O(C), C is the capacity
     */
    static class LRUCache {

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }

        private int cnt;
        private int capacity;

        // two dummy nodes head and tail
        private Node head;
        private Node tail;
        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cnt = 0;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.prev = null;
            head.next = tail;
            tail.prev = head;
            tail.next = null;

            this.map = new HashMap<>();
        }

        // add node to the head
        public void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        // remove node
        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public Node popNode() {
            Node tmp = tail.prev;
            this.removeNode(tmp);
            return tmp;
        }


        public int get(int key) {
            Node cur = map.get(key);
            if (cur == null) {
                return -1;
            }
            removeNode(cur);
            addNode(cur);
            return cur.value;
        }

        public void put(int key, int value) {
            Node cur = map.get(key);
            if (cur == null) {
                Node tmp = new Node(key, value);
                addNode(tmp);
                map.put(key, tmp);
                cnt++;

                if (cnt > capacity) {
                    Node tailNode = popNode();
                    map.remove(tailNode.key);
                    cnt--;
                }
            } else {
                cur.value = value;
                removeNode(cur);
                addNode(cur);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
