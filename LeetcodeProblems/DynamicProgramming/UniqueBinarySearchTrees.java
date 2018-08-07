package DynamicProgramming;

/**
 * Created by sjwang on 08/07/2018.
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int num[] = new int[n + 1];
        num[0] = 1;
        for(int i = 1; i < n + 1; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += num[j] * num[i - j - 1];
            }
            num[i] = sum;
        }
        return num[n];
    }
    public static void main(String args[]){
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }
}
