package Airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListOfListInteger_3 implements Iterator<Integer> {

    private Iterator<List<Integer>> rowIterator;
    private Iterator<Integer> colIterator;

    public ListOfListInteger_3(List<List<Integer>> list) {
        this.rowIterator = list.iterator();
        this.colIterator = Collections.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        while((colIterator == null || !colIterator.hasNext()) && rowIterator.hasNext()) {
            colIterator = rowIterator.next().iterator();
        }
        return colIterator != null && colIterator.hasNext();
    }

    @Override
    public Integer next() {
        return colIterator.next();
    }

    @Override
    public void remove() {
        while(colIterator == null && rowIterator.hasNext()) {
            colIterator = rowIterator.next().iterator();
        }
        if (colIterator != null) {
            colIterator.remove();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1= new ArrayList<>();
        l1.add(1); l1.add(2);
        List<Integer> l2= new ArrayList<>();
        l2.add(3);
        List<Integer> l3= new ArrayList<>();
        l3.add(4); l3.add(5); l3.add(6);
        list.add(l1); list.add(l2); list.add(l3);

        ListOfListInteger_3 l = new ListOfListInteger_3(list);
        System.out.println(l.hasNext());
        System.out.println(l.next());
        System.out.println(l.hasNext());
        System.out.println(l.next());
        l.remove();
        System.out.println(l.hasNext());
        System.out.println(l.next());

        for (List<Integer> L: list) {
            for (int n: L) {
                System.out.print(n + " ");
            }
        }
    }

}
