package Airbnb;


import java.util.*;

public class BoggleGame_24 {

    /**
     * lc79 - word searchI, DFS
     * @param board
     * @param target
     * @return
     */
    public boolean wordSearch(char[][] board, String target) {
        if (target.length() == 0 || target == null) return false;

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == target.charAt(0)) {
                    if(search(board, i, j, visited, target, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, boolean[][] visited, String target, int cnt) {
        if (cnt == target.length()) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;


        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || board[i][j] != target.charAt(cnt)) {
            return false;
        }

        visited[i][j] = true;

        if (search(board, i - 1, j, visited, target, cnt + 1) ||
                search(board, i + 1, j, visited, target, cnt + 1) ||
                search(board, i, j - 1, visited, target, cnt + 1) ||
                search(board, i, j + 1, visited, target, cnt + 1)) {
            return true;
        }

        visited[i][j] = false;

        return false;
    }


    /**
     * lc212 - word searchII, DFS + trie
     * @param board
     * @param words
     * @return
     */
    public void findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        int row = board.length;
        int col = board[0].length;
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[row][col];
        int max = 0;

        List<List<int[]>> maxPath = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                List<List<int[]>> curPath = new ArrayList<>();
                List<int[]> tmpPath = new ArrayList<>();

//                DFS(board, i, j, set, "", trie, visited);
                DFS_findMaxPath(curPath, tmpPath, board, i, j, set, "", trie, visited);
                if (curPath.size() > max) {
                    maxPath = curPath;
                    max = curPath.size();
                    System.out.println("max num: " + curPath.size());
                }
            }
        }
        // print the max path
        for (List<int[]> list: maxPath) {
            for (int[] n: list) {
                System.out.print(n[0] + " " + n[1] + " ");
            }
            System.out.println();
        }
//        for (String s: set) {
//            res.add(s);
//        }
//        return res;
        return;
    }

    // find the number of valid words on the board
    public void DFS(char[][] board, int i, int j, Set<String> res, String cur, Trie trie, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        cur += board[i][j];
        if (!trie.hasPerfix(cur)) return;
        if (trie.hasWord(cur)) {
            res.add(cur);
            return;
        }
        visited[i][j] = true;
        DFS(board, i - 1, j, res, cur, trie, visited);
        DFS(board, i + 1, j, res, cur, trie, visited);
        DFS(board, i, j - 1, res, cur, trie, visited);
        DFS(board, i, j + 1, res, cur, trie, visited);
        visited[i][j] = false;
        return;
    }


    /**
     * Airbnb - Find the path that contains most words and print the path
     *
     * similar to lc212, DFS + trie
     *
     * should not return when find a word!
     *
     */
    public void DFS_findMaxPath(List<List<int[]>> curPath, List<int[]> tmpPath, char[][] board, int i, int j,
                                Set<String> res, String cur, Trie trie, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        cur += board[i][j];
        if (!trie.hasPerfix(cur)) return;

        int[] tmp = new int[]{i, j};
        tmpPath.add(tmp);

        if (trie.hasWord(cur)) {
            res.add(cur);
            cur = "";
            curPath.add(tmpPath);
            tmpPath = new ArrayList<>();
        }
        visited[i][j] = true;
        DFS_findMaxPath(curPath, tmpPath, board, i - 1, j, res, cur, trie, visited);
        DFS_findMaxPath(curPath, tmpPath, board, i + 1, j, res, cur, trie, visited);
        DFS_findMaxPath(curPath, tmpPath, board, i, j - 1, res, cur, trie, visited);
        DFS_findMaxPath(curPath, tmpPath, board, i, j + 1, res, cur, trie, visited);
        visited[i][j] = false;
        return;
    }

    public static class Trie {

        public static class Node {
            Map<Character, Node> children;
            boolean isEnd;
            public Node() {
                this.children = new HashMap<>();
                this.isEnd = false;
            }
        }

        Node root;
        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!tmp.children.containsKey(ch)) {
                    tmp.children.put(ch, new Node());
                }
                tmp = tmp.children.get(ch);
            }
            tmp.isEnd = true;
        }

        public boolean hasWord(String word) {
            Node tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!tmp.children.containsKey(ch)) {
                    return false;
                }
                tmp = tmp.children.get(ch);
            }
            return tmp.isEnd;
        }

        public boolean hasPerfix(String perfix) {
            Node tmp = root;
            for (int i = 0; i < perfix.length(); i++) {
                char ch = perfix.charAt(i);
                if (!tmp.children.containsKey(ch)) {
                    return false;
                }
                tmp = tmp.children.get(ch);
            }
            return true;
        }

    }



    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'a','t','a','u'},{'i','h','k','r'},{'i','f','l','y'}};
        String[] words = {"oath","pea","run","fly"};
        new BoggleGame_24().findWords(board, words);
//        System.out.println(max);
//        for (String s: res) {
//            System.out.println(s);
//        }
    }
}
