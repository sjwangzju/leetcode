package FullTime.Facebook;

public class Flatten2DVector {

    // Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
    //
    // Solution:
    // 1. 2d array with pointers

    class Vector2D {

        int i, j;
        int[][] v;
        public Vector2D(int[][] v) {
            this.i = 0;
            this.j = 0;
            this.v = v;
        }

        // time: O(1)
        public int next() {
            if (!hasNext()) return -1;
            return v[i][j++];
        }

        // time: O(N)
        public boolean hasNext() {
            while (i < v.length) {
                if (j < v[i].length) return true;
                j = 0;
                i++;
            }
            return false;
        }
    }
}
