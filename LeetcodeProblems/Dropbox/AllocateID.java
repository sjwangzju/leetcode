package Dropbox;

import java.util.*;

public class AllocateID {

//    // Queue + Set
//    // time: O(1)
//    // space: O(N)
//
//    public Queue<Integer> availableID;
//    public Set<Integer> usedID;
//    public int maxID;
//
//    public AllocateID(int N) {
//        this.availableID = new LinkedList<>();
//        this.usedID = new HashSet<>();
//        this.maxID = N;
//
//        for (int i = 0; i < maxID; i++) {
//            availableID.offer(i);
//        }
//    }
//
//    public int allocate() {
//        if (availableID.isEmpty()) {
//            return -1;
//        }
//        int res = availableID.poll();
//        usedID.add(res);
//        return res;
//    }
//
//    public void release(int id) {
//        if (usedID.contains(id)) {
//            usedID.remove(id);
//            availableID.offer(id);
//        }
//    }


    /****************************************************************************************/
//    // BitSet
//    // time: O(N)
//    // space: O(N)
//
//    public int maxID;
//    public BitSet bitSet;
//    public int nextAvailable;
//
//    public AllocateID(int N) {
//        this.maxID = N;
//        this.bitSet = new BitSet();
//        this.nextAvailable = 0;
//    }
//
//    public int allocate() {
//        if (nextAvailable == maxID) return -1;
//        int next = nextAvailable;
//        bitSet.set(next);
//        nextAvailable = bitSet.nextClearBit(next);
//        return next;
//    }
//
//    public void release(int id) {
//        if (id < 0 || id >= maxID) return;
//        if (bitSet.get(id)) {
//            bitSet.clear(id);
//            nextAvailable = Math.min(nextAvailable, id);
//        }
//    }


    /****************************************************************************************/
    // Segment Tree + BitSet
    // time: O(logN)
    // space: O(N)

    public int maxID;
    public BitSet bitSet;

    public AllocateID(int N) {
        if (N % 2 == 1) {
            this.bitSet = new BitSet(2 * (N + 1) - 1);
            bitSet.set(2 * (N + 1) - 2);
            this.maxID = N + 1;
        } else {
            this.bitSet = new BitSet(2 * N - 1);
            this.maxID = N;
        }
    }

    public int allocate() {
        int index = 0;
        while (index < maxID - 1) {
            if (!bitSet.get(2 * index + 1)) {
                index = 2 * index + 1;
            } else if (!bitSet.get(2 * index + 2)) {
                index = 2 * index + 2;
            } else {
                return -1;
            }
        }

        bitSet.set(index);
        updateTree(index);

        return index - maxID + 1;
    }

    public void updateTree(int index) {

        while (index > 0) {
            int parent = (index - 1) / 2;

            // left node
            if (index % 2 == 1) {
                if (bitSet.get(index) && bitSet.get(index + 1)) {
                    bitSet.set(parent);
                } else {
                    bitSet.clear(parent);
                }
            } else {
                if (bitSet.get(index) && bitSet.get(index - 1)) {
                    bitSet.set(parent);
                } else {
                    bitSet.clear(parent);
                }
            }
            index = parent;
        }
    }

    public boolean check(int number) {
        return !bitSet.get(number + maxID - 1);
    }

    public void release(int id) {
        if (id < 0 || id >= maxID) return;
        int tmp = id + maxID - 1;
        if (bitSet.get(tmp)) {
            bitSet.clear(tmp);
            updateTree(tmp);
        }
    }


    /****************************************************************************************/
    public static void main(String[] args) {
        AllocateID allocator = new AllocateID(3);
        int id1 = allocator.allocate();
        int id2 = allocator.allocate();
        System.out.println(allocator.check(2));
        int id3 = allocator.allocate();
        System.out.println(allocator.check(2));
        allocator.release(2);
        System.out.println(allocator.check(2));
        System.out.println(id1 + " " + id2 + " " + id3 );
    }
}
