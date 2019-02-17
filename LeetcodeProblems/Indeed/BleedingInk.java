package Amazon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BleedingInk {

    public static class inkDrop {
        int row;
        int col;
        int darkness;

        public inkDrop(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.darkness = d;
        }
    }

    public static class paper {
        int H;
        int W;
        int num;
        List<int[]> drops;

        public paper(int H, int W, int num, List<int[]> drops) {
            this.H = H;
            this.W = W;
            this.num = num;
            this.drops = drops;
        }
    }

    public int totalDarkness(paper p) {
        int H = p.H;
        int W = p.W;
        List<int[]> drop = p.drops;
        int[][] paper = new int[H][W];
        List<inkDrop> list = new LinkedList<>();

        for (int[] d: drop) {
            inkDrop tmp = new inkDrop(d[0], d[1], d[2]);
            list.add(tmp);
        }
        Collections.sort(list, (a,b) -> (b.darkness - a.darkness));

        for (inkDrop i: list) {
            int curR = i.row;
            int curC = i.col;
            int curD = i.darkness;
            int lastD = paper[curR][curC];
            if (curD > lastD) {
                paper[curR][curC] = curD;
                dfs(paper, curR, curC, curD);
            }
        }

        int sum = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sum += paper[i][j];
            }
        }
        return sum;
    }

    public void dfs(int[][] paper, int curR, int curC, int curD) {
        int H = paper.length;
        int W = paper[0].length;
        int[][] dirs1 = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] dir: dirs1) {
            int nextR = curR + dir[0];
            int nextC = curC + dir[1];
            int nextD = curD - 1;
            while (nextR >= 0 && nextR < H && nextC >= 0 && nextC < W && nextD > paper[nextR][nextC]) {
                paper[nextR][nextC] = nextD;
                nextD--;
                nextR += dir[0];
                nextC += dir[1];
            }
        }

        int[][] dirs2 = {{-1,-1},{-1,1},{1,-1},{1,1}};
        for (int[] dir: dirs2) {
            int diagR = curR + dir[0];
            int diagC = curC + dir[1];
            int diagD = curD - Math.abs(curR - diagR) - Math.abs(curC - diagC);
            if (diagR >= 0 && diagR < H && diagC >= 0 && diagC < W && diagD > paper[diagR][diagC]) {
                paper[diagR][diagC] = diagD;
                dfs(paper, diagR, diagC, diagD);
            }
        }
    }

    // read input from stdIn
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paperN = scanner.nextInt();
        List<paper> papers = new LinkedList<>();

        for (int i = 0; i < paperN; i++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int cnt = scanner.nextInt();
            List<int[]> list = new LinkedList<>();
            for (int j = 0; j < cnt; j++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int darkness = scanner.nextInt();
                list.add(new int[]{row, col, darkness});
            }
            paper p = new paper(H, W, cnt, list);
            papers.add(p);
        }

        for (int i = 0; i < paperN; i++) {
            paper p = papers.get(i);
            int res = new BleedingInk().totalDarkness(p);
            System.out.println(res);
        }
    }
}
