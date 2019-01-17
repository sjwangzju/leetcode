package DynamicProgramming;

public class MovieRatings {
    public int largestSum (int[] movies) {
        int len = movies.length;
        if (len == 1) {
            return movies[0];
        } else if (len == 2) {
            return Math.max(movies[0], movies[1]);
        }
        int[] res = new int[len];
        res[0] = Math.max(0, movies[0]);
        res[1] = Math.max(res[0] + movies[1], movies[0]);
        for (int i = 2; i < len; i++) {
            res[i] = Math.max(res[i - 2] + movies[i - 1], res[i - 1] + movies[i]);
        }
        return res[len - 1];
    }

    public static void main (String[] args) {
        int[] movies = {8,-10,-8,-2,6};
        System.out.println(new MovieRatings().largestSum(movies));
    }
}
