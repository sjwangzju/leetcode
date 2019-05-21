package Dropbox;

import java.util.HashMap;
import java.util.Map;

public class NASA {

    public class Node {
        int x;
        int y;
        Object img;
        Node prev;
        Node next;

        public Node(int x, int y, Object img) {
            this.x = x;
            this.y = y;
            this.img = img;
            this.prev = null;
            this.next = null;
        }
    }

    Map<Position, Node> map;
    Node head;
    Node tail;
    int size;
    int capacity;

    public NASA(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1,-1,null);
        this.tail = new Node(-1,-1,null);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public Object getImg(int x, int y) {
        Position pos = new Position(x, y);
        if (!map.containsKey(pos)) return null;

        Node res = map.get(pos);
        removeNode(res);
        addToHead(res);
        return res.img;
    }

    public void setImg(int x, int y, Object img) {
        Position pos = new Position(x, y);
        if (map.containsKey(pos)) {
            Node n = map.get(pos);
            n.img = img;
            removeNode(n);
            addToHead(n);
        } else {
            if (size == capacity) {
                Node last = tail.prev;
                map.remove(new Position(last.x, last.y));
                removeNode(last);
                size--;
            }
            Node n = new Node(x, y, img);
            map.put(pos, n);
            size++;
            addToHead(n);
        }
    }

    public void setLeastUpdated(Object img) {
        Node last = tail.prev;
        last.img = img;
        removeNode(last);
        addToHead(last);
    }

    public class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    // FOLLOWUP: If the image is very large, we need a distributed file system (HDFS)
}
