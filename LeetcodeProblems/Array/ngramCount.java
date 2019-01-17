package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ngramCount {
    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner input = new Scanner(new File("/Users/Coco/Desktop/courses/18781/HW3/swb.count"));
        ArrayList<String> readFile = new ArrayList<>();
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2.split("\t")[1]) - Integer.valueOf(o1.split("\t")[1]);
            }
        };
        PriorityQueue<String> ones = new PriorityQueue<>(comp);
        PriorityQueue<String> twoes = new PriorityQueue<>(comp);
        PriorityQueue<String> threes = new PriorityQueue<>(comp);

        int[] count = new int[3];
        while (input.hasNextLine()){
            readFile.add(input.nextLine());
        }
        for(int i = 0; i < readFile.size(); i++){
            String curLine = readFile.get(i);
            String[] words = curLine.split("\t")[0].split(" ");
            switch (words.length){
                case 1:
                    ones.add(curLine);break;
                case 2:
                    twoes.add(curLine);break;
                case 3:
                    threes.add(curLine);break;
            }
        }
        System.out.println("Top 1-grams");
        for (int i = 0; i < 20; i++) {
            System.out.println(ones.poll());
        }
        System.out.println("----------");
        System.out.println("Top 2-grams");
        for (int i = 0; i < 20; i++) {
            System.out.println(twoes.poll());
        }
        System.out.println("----------");
        System.out.println("Top 3-grams");
        for (int i = 0; i < 20; i++) {
            System.out.println(threes.poll());
        }
    }
}
