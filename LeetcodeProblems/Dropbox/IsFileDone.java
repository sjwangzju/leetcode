package Dropbox;

import java.util.*;

public class IsFileDone {

    public static class Chunk {
        int start;
        int end;

        public Chunk(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /****************************************************************************************/
    // if all chunks are given
    // time: O(NlogN)
    // space: O(N)
    public boolean isFileDone(List<Chunk> chunks, int size) {
        Collections.sort(chunks, (a,b) -> (a.start - b.start));

        int end = chunks.get(0).end;

        for (int i = 1; i < chunks.size(); i++) {
            Chunk cur = chunks.get(i);
            if (cur.start > end) return false;
            end = Math.max(cur.end, end);
        }
        return end == size;
    }


    /****************************************************************************************/
    // bitSet.cardinality() --> Returns the number of bits set to true in this BitSet.
    // time: O(1)
    // space: O(N)
    public static class chunkManagerII{
        int size;
        BitSet bitSet;

        public chunkManagerII(int size) {
            this.size = size;
            this.bitSet = new BitSet(size);
        }

        public void addChunk(Chunk chunk) {
            bitSet.set(chunk.start, chunk.end);
        }

        public boolean isDone() {
            return bitSet.cardinality() == size;
        }
    }


    /****************************************************************************************/
    // chunks are inserted one by one
    // time: O(logN)
    // space: worst O(N)
    public static class chunkManagerI{
        PriorityQueue<Chunk> pq;
        int size;

        public chunkManagerI(int size) {
            this.pq = new PriorityQueue<>((a,b) -> (a.start - b.start));
            this.size = size;
        }

        public void addChunk(Chunk chunk) {
            pq.offer(chunk);
            if (pq.size() > 1) {
                Chunk first = pq.poll();
                while (!pq.isEmpty() && pq.peek().start <= first.end) {
                    Chunk c = pq.poll();
                    first.end = Math.max(first.end, c.end);
                }
                pq.offer(first);
            }
        }

        public boolean isDone() {
            if (!pq.isEmpty()) {
                Chunk first = pq.poll();
                if (first.start == 0 && first.end == size) return true;
            }
            return false;
        }
    }


    public static void main(String[] args) {
//        List<Chunk> chunks = new LinkedList<>();
//        chunks.add(new Chunk(0,1));
//        chunks.add(new Chunk(1,2));
//        chunks.add(new Chunk(2,3));
//        System.out.println(new IsFileDone().isFileDone(chunks,3));

        chunkManagerII cm = new chunkManagerII(3);
        cm.addChunk(new Chunk(0,1));
        cm.addChunk(new Chunk(1,2));
        cm.addChunk(new Chunk(2,3));
        System.out.println(cm.isDone());
    }
}
