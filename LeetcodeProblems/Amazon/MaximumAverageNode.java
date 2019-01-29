package Amazon;

import java.util.ArrayList;

public class MaximumAverageNode {

    public static class CategoryNode {
        public int value;
        public ArrayList<CategoryNode> subCategoryNode;

        public CategoryNode(int tenure) {
            this.value = tenure;
            this.subCategoryNode = new ArrayList<>();
        }
    }

    public CategoryNode maximumAverage(CategoryNode root) {
        CategoryNode[] res = new CategoryNode[1];
        double[] max = new double[1];
        max[0] = Double.MIN_VALUE;
        search(root, max, res);
        return res[0];
    }

    public int[] search(CategoryNode root, double[] max, CategoryNode[] res) {
        if (root == null) return new int[2];
        int[] n = new int[2];
        n[0] = root.value;
        n[1] = 1;
        for (CategoryNode c: root.subCategoryNode) {
            n[0] += search(c, max, res)[0];
            n[1] += search(c, max, res)[1];
        }
        if (n[1] > 1 && (double) (n[0] / n[1]) > max[0]) {
            max[0] = (double) (n[0] / n[1]);
            res[0] = root;
        }
        return n;
    }

    public static void main(String[] args) {
        CategoryNode n1 = new CategoryNode(5);
        CategoryNode n21 = new CategoryNode(6);
        CategoryNode n22 = new CategoryNode(8);
        CategoryNode n31 = new CategoryNode(7);
        CategoryNode n32 = new CategoryNode(10);
        CategoryNode n33 = new CategoryNode(3);
        CategoryNode n34 = new CategoryNode(1);

        n1.subCategoryNode.add(n21);
        n1.subCategoryNode.add(n22);
        n21.subCategoryNode.add(n31);
        n21.subCategoryNode.add(n32);
        n22.subCategoryNode.add(n33);
        n22.subCategoryNode.add(n34);

        CategoryNode res = new MaximumAverageNode().maximumAverage(n1);
        System.out.println(res.value);
    }
}
