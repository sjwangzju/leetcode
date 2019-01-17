package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.log;

public class cluster {
    public List<List<Double>> cluster(List<List<Double>> model) {
        int cnt = 1, size = model.size();
        while (cnt < size) {
            System.out.println("Clustering step: " + cnt);
            clustering(model);
            cnt++;
        }
        return model;
    }

    public void clustering(List<List<Double>> model) {
        double min_dis = Integer.MAX_VALUE;
        List<Double> ad = new LinkedList<>(), li = new ArrayList<>(), lj = new ArrayList<>();
        int pos_i = 0, pos_j = 0;
        for (int i = 0; i < model.size() - 1; i++) {
            for (int j = i + 1; j < model.size(); j++) {
                if (model.get(i).size() != 0 && model.get(j).size() != 0) {
                    double hf = getEntropy(model.get(i)), nf = model.get(i).get(2);
                    double hg = getEntropy(model.get(j)), ng = model.get(j).get(2);
                    List<Double> tmp = new LinkedList<>();

                    tmp.add((model.get(i).get(0)  * model.get(i).get(2)
                            + model.get(j).get(0)  * model.get(j).get(2)) / (model.get(i).get(2) +  model.get(j).get(2)));

                    tmp.add(( model.get(i).get(1) * model.get(i).get(2)
                            +  model.get(j).get(1) * model.get(j).get(2)) / ( model.get(i).get(2) + model.get(j).get(2)));

                    tmp.add(model.get(i).get(2) + model.get(j).get(2));
                    double hfg = getEntropy(tmp), nfg = tmp.get(2);
                    double dis = nfg * hfg - nf * hf - ng * hg;
                    if (dis < min_dis) {
                        min_dis = dis;
                        pos_i = i;
                        pos_j = j;
                        ad = tmp;
                        li = model.get(pos_i);
                        lj = model.get(pos_j);
                    }
                }
            }
        }
        System.out.println("Model Before Merge:");
        printModel(model);
        System.out.println();
        System.out.println("Two merged clusters:");
        System.out.print("T" + (pos_i+1) + ": ");
        System.out.print("[" + li.get(0) + ", ");
        System.out.print(li.get(1) + "] ");
        System.out.println("with " + (int)((double)li.get(2)) + " training examples");

        System.out.print("T" + (pos_j+1) + ": ");
        System.out.print("[" + lj.get(0) + ", ");
        System.out.print(lj.get(1) + "] ");
        System.out.println("with " + (int)((double)lj.get(2)) + " training examples");
        System.out.println();

        System.out.println("weighted discrete entropy distance: " + String .format("%.3f",min_dis));
        System.out.println();

        System.out.print("new-formed cluster: " + "T" + (model.size() + 1) + ": ");
        System.out.print("[" + ad.get(0) + ", ");
        System.out.print(ad.get(1) + "] ");
        System.out.println("with " + (int)((double)ad.get(2)) + " training examples");
        System.out.println();

        model.remove(pos_i);
        model.add(pos_i, new LinkedList<>());
        model.remove(pos_j);
        model.add(pos_j, new LinkedList<>());
        model.add(ad);
        System.out.println("Model After Merge:");
        printModel(model);
        System.out.println();
        System.out.println();
        return;
    }

    public double getEntropy(List<Double> list) {
        double sum = 0;
        for (int i = 0; i < 2; i++) {
            double n = list.get(i);
            sum += n * log((1/n))/log((double)2);
        }
        return sum;
    }

    public void printModel(List<List<Double>> model) {
        for (int i = 0; i < model.size(); i++) {
            System.out.print("T" + (i+1) + ": ");
            if (model.get(i).size() == 0) {
                System.out.println();
            } else {
                System.out.print("[" + model.get(i).get(0) + ", ");
                System.out.print(model.get(i).get(1) + "] ");
                System.out.print("with " + (int)((double)model.get(i).get(2)) + " training examples");
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        List<List<Double>> L = new LinkedList<>();
        List<Double> l1 = new LinkedList<>();
        l1.add((double)1/4); l1.add((double)3/4); l1.add((double)16);

        List<Double> l2 = new LinkedList<>();
        l2.add((double)1/8); l2.add((double)7/8); l2.add((double)8);

        List<Double> l3 = new LinkedList<>();
        l3.add((double)3/8); l3.add((double)5/8); l3.add((double)32);

        List<Double> l4 = new LinkedList<>();
        l4.add((double)5/8); l4.add((double)3/8); l4.add((double)8);

        List<Double> l5 = new LinkedList<>();
        l5.add((double)7/8); l5.add((double)1/8); l5.add((double)16);

        List<Double> l6 = new LinkedList<>();
        l6.add((double)3/4); l6.add((double)1/4); l6.add((double)4);

        L.add(l1); L.add(l2); L.add(l3); L.add(l4); L.add(l5); L.add(l6);
        List<List<Double>> res = new cluster().cluster(L);
        System.out.println("final model: ");
        System.out.print("[" + res.get(res.size() - 1).get(0) + ", ");
        System.out.print(res.get(res.size() - 1).get(1) + "] ");
        System.out.println("with " + (int)((double)res.get(res.size() - 1).get(2)) + " training examples");
    }
}
