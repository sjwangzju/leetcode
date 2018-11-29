package Airbnb;

public class PourWater_14 {
    /**
     * lc755
     * @param heights
     * @param V
     * @param k
     * @return
     */
    public int[] pourWater(int[] heights, int V, int k) {
        int[] drop = new int[heights.length];
        while (V > 0) {
            int left = findLeftLowest(heights, k);
            if (heights[left] < heights[k]) {
                heights[left]++;
                drop[left]++;
            } else {
                int right = findRightLowest(heights, k);
                if (heights[right] < heights[k]) {
                    heights[right]++;
                    drop[right]++;
                } else {
                    heights[k]++;
                    drop[k]++;
                }
            }
            V--;
        }
        // print
        printWaterLand(heights, drop);

        return heights;
    }

    /**
     * Airbnb print water land
     * @param heights
     * @param drop
     */
    public void printWaterLand(int[] heights, int[] drop) {
        int maxHeight = 0;
        int[] originHeight = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
            originHeight[i] = heights[i] - drop[i];
        }
        for (int h = maxHeight; h >= 1; h--) {
            for (int i = 0; i < heights.length; i++) {
                if (h <= originHeight[i]) {
                    System.out.print("# ");
                } else if (h > originHeight[i] && h <= heights[i]) {
                    System.out.print("w ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public int findLeftLowest(int[] heights, int k) {
        int low = k;
        while (k >= 0) {
            if (heights[k] < heights[low]) {
                low = k;
            }
            if (heights[k] > heights[low]) {
                return low;
            }
            k--;
        }
        return low;
    }

    public int findRightLowest(int[] heights, int k) {
        int low = k;
        while (k < heights.length) {
            if (heights[k] < heights[low]) {
                low = k;
            }
            if (heights[k] > heights[low]) {
                return low;
            }
            k++;
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] heights1 = {2,1,1,2,1,2,2}; int V= 4; int k = 3;
//        int[] heights2 = {1,2,3,4}; int V = 2; int k = 2;
        int[] heights3 = {1,2,3,4,3,2,1,2,3,4,3,2,1}; int V = 5; int k = 5;

        PourWater_14 pour = new PourWater_14();
        pour.pourWater(heights3, V, k);
        for (int i : heights3) {
            System.out.println(i);
        }
    }
}
