package Dropbox;

import java.util.*;

public class kvStore {

    public static class Transaction {
        int size;
        List<Map<String, Integer>> trans;
        Map<String, Integer> write;
        Map<String, Integer> globalData;
        Map<Integer, Map<String, Integer>> map;

        public Transaction(Map<String, Integer> data) {
            this.globalData = new HashMap<>(data);
            this.trans = new LinkedList<>();
            this.size = 0;
            this.write = new HashMap<>();
            this.map = new HashMap<>();
        }

        public int begin() {
            trans.add(new HashMap<>(globalData));
            size++;
            return size;
        }

        public Integer read(int transaction_id, String key) {
            return trans.get(transaction_id - 1).get(key);
        }


        public void write(int transaction_id, String key, int value) {

            // no other transaction is writing or has the write lock itself
            if (!write.containsKey(key) || write.get(key) == transaction_id) {

                // update local data
                trans.get(transaction_id - 1).put(key, value);

                // get write lock
                write.put(key, transaction_id);

                // add new data into map
                if (!map.containsKey(transaction_id)) {
                    map.put(transaction_id, new HashMap<>());
                }
                map.get(transaction_id).put(key, value);
            }
        }


        public void commit (int transaction_id) {

            Map<String, Integer> newData = map.get(transaction_id);
            for (String s: newData.keySet()) {
                // commit to global data
                globalData.put(s, newData.get(s));

                // synchronize to all transactions
                for (int i = 0; i < size; i++) {
                    trans.get(i).put(s, newData.get(s));
                }
            }

            // release write lock for that key
            for (String s: write.keySet()) {
                if (write.get(s).equals(transaction_id)) {
                    write.remove(s);
                    break;
                }
            }

            // clear
            map.remove(transaction_id);
        }
    }

    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        Transaction transaction = new Transaction(map);
        System.out.println("start transactions:");
        transaction.begin();
        transaction.begin();

        System.out.println("read:");
        System.out.println(transaction.read(1,"A"));
        System.out.println(transaction.read(2,"A"));
        System.out.println(transaction.read(1,"B"));
        System.out.println(transaction.read(2,"B"));


        System.out.println("write:");
        transaction.write(1,"A",5);
        transaction.write(2,"A",10);
        transaction.write(2,"B",10);

        System.out.println("read:");
        System.out.println(transaction.read(1,"A"));
        System.out.println(transaction.read(2,"A"));
        System.out.println(transaction.read(1,"B"));
        System.out.println(transaction.read(2,"B"));


        System.out.println("commit:");
        transaction.commit(1);

        System.out.println(transaction.read(1,"A"));
        System.out.println(transaction.read(2,"A"));
        System.out.println(transaction.read(1,"B"));
        System.out.println(transaction.read(2,"B"));

        transaction.commit(2);

        System.out.println(transaction.read(1,"A"));
        System.out.println(transaction.read(2,"A"));
        System.out.println(transaction.read(1,"B"));
        System.out.println(transaction.read(2,"B"));


        transaction.begin();
        System.out.println("read:");
        System.out.println(transaction.read(3,"A"));
        System.out.println(transaction.read(3,"B"));
    }
}
