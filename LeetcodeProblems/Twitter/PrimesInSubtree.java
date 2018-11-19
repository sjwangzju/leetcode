package Twitter;

import java.util.LinkedList;
import java.util.List;

public class PrimesInSubtree {
    public List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        int[] prime = new int[values.size() + 1];
        int[] cnt = new int[values.size() + 1];
        List<Integer> ret = new LinkedList<>();
        int[] parent = new int[values.size() + 1];

        for (int i = 1; i <= values.size(); i++) {
            prime[i] = isPrime(values.get(i - 1)) ? 1 : 0;
        }

        for (int i = 1; i <= second.size(); i++) {
            parent[second.get(i - 1)] = first.get(i - 1);
        }
        parent[1] = 1;

        for (int i = 1; i < parent.length; i++) {
            if (prime[i] == 1) {
                cnt[i]++;
                int k = i;
                while (parent[k] != k) {
                    k = parent[k];
                    cnt[k]++;
                }
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            ret.add(i, cnt[queries.get(i)]);
        }
        return ret;
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 6;
        List<Integer> first = new LinkedList<>();
        first.add(6);first.add(8);first.add(3);first.add(6);first.add(4);first.add(1);first.add(8);first.add(5);first.add(1);

        List<Integer> second = new LinkedList<>();
        second.add(9);second.add(9);second.add(5);second.add(7);second.add(8);second.add(8);second.add(10);second.add(8);second.add(2);

        List<Integer> values = new LinkedList<>();
        values.add(17);values.add(29);values.add(3);values.add(20);values.add(11);values.add(8);values.add(3);values.add(23);values.add(5);values.add(15);

        List<Integer> queries = new LinkedList<>();
        queries.add(1);queries.add(8);queries.add(9);queries.add(6);queries.add(4);

        List<Integer> ret = new PrimesInSubtree().primeQuery(n, first, second, values, queries);
        for (int r: ret) {
            System.out.println(r);
        }
    }
}
