package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseOrder {

    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        ArrayList<String> revFile = new ArrayList<String>();

        Scanner input = new Scanner(new File("/Users/Coco/Desktop/courses/18781/HW3/swb/swb.heldout3"));
        File file =new File("/Users/Coco/Desktop/courses/18781/HW3/swb/swb.heldout3.reverse");
        Writer out =new FileWriter(file);

        while (input.hasNextLine()){
            revFile.add(input.nextLine());
        }
        for(int i = 0; i < revFile.size(); i++){
            //System.out.println(revFile.size());
            String ar[]=revFile.get(i).split(" ");
            for(int j = ar.length - 1; j >= 0; j--){
                out.write(ar[j]);
                out.write(" ");
            }
            out.write("\n");
            ar=null;
        }
        out.close();
    }
}
