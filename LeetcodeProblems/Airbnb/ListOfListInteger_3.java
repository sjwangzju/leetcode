package Airbnb;

import java.util.*;

public class ListOfListInteger_3 implements Iterator<Integer> {

//    private Iterator<List<Integer>> rowIterator;
//    private Iterator<Integer> colIterator;
//
//    public ListOfListInteger_3(List<List<Integer>> list) {
//        this.rowIterator = list.iterator();
//        this.colIterator = Collections.emptyIterator();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while((colIterator == null || !colIterator.hasNext()) && rowIterator.hasNext()) {
//            colIterator = rowIterator.next().iterator();
//        }
//        return colIterator != null && colIterator.hasNext();
//    }
//
//    @Override
//    public Integer next() {
//        return colIterator.next();
//    }
//
//    @Override
//    public void remove() {
//        while((colIterator == null || !colIterator.hasNext()) && rowIterator.hasNext()) {
//            colIterator = rowIterator.next().iterator();
//        }
//        if (colIterator != null) {
//            colIterator.remove();
//        }
//    }

    Iterator<List<Integer>> list;
    Iterator<Integer> num;

    public ListOfListInteger_3(List<List<Integer>> input){
        if (input == null || input.size() == 0) return;
        list = input.iterator();
        num = list.next().iterator();
        // getNextNum();
    }

    public void getNextNum(){
        while (!num.hasNext() && list.hasNext()) {
            num = list.next().iterator();
        }
    }

    public boolean hasNext() {
        getNextNum();
        return num != null && num.hasNext();
    }

    public Integer next(){
        return num.next();
    }

    public void remove(){
        num.remove();
        return;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1= new ArrayList<>();
        l1.add(1); l1.add(2); l1.add(3);
        List<Integer> l2= new ArrayList<>();
        l2.add(3);
        List<Integer> l3= new ArrayList<>();
        l3.add(4); l3.add(5); l3.add(6);
        list.add(l1); list.add(l2); list.add(l3);

        ListOfListInteger_3 l = new ListOfListInteger_3(list);
        System.out.println(l.hasNext());
        System.out.println(l.next());
        l.remove();
        System.out.println(l.hasNext());
        System.out.println(l.next());
        l.remove();
        System.out.println(l.hasNext());
        System.out.println(l.next());
        System.out.println(l.hasNext());
        System.out.println(l.next());
    }

}
