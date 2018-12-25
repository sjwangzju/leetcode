package Airbnb;


import java.util.*;

public class BoggleGame_24 {

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





//    /**
//     * lc212 - word searchII, DFS + trie
//     * @param board
//     * @param words
//     * @return
//     */
//    public void findWords(char[][] board, String[] words) {
//        Trie trie = new Trie();
//        Set<String> dict = new HashSet<>();
//        Map<int[], int[]> parent = new HashMap<>();
//        for (String word: words) {
//            trie.insert(word);
//        }
//        int row = board.length;
//        int col = board[0].length;
//        List<String> set = new LinkedList<>();
//        List<String> res = new LinkedList<>();
//        boolean[][] visited = new boolean[row][col];
//        int max = 0;
//
//        List<List<int[]>> maxPath = new ArrayList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                List<List<int[]>> curPath = new ArrayList<>();
//                List<int[]> tmpPath = new ArrayList<>();
//                set = new LinkedList<>();
//                for (String word: words) {
//                    dict.add(word);
//                }
//                DFS_findMaxPath(dict, curPath, tmpPath, board, i, j, set, "", trie, visited);
//                if (curPath.size() > max) {
//                    maxPath = curPath;
//                    max = curPath.size();
//                    res = set;
//                }
//            }
//        }
//
//        // print the max path
//        System.out.println("max num: " + max);
//        for (List<int[]> list: maxPath) {
//            for (int[] n: list) {
//                System.out.print("(" + n[0] + ", " + n[1] + ") ");
//            }
//            System.out.println();
//        }
//
//        for (String s: res) {
//            System.out.println(s);
//        }
//
//        return;
//    }

//    // find the number of valid words on the board
//    public void DFS(char[][] board, int i, int j, Set<String> res, String cur, Trie trie, boolean[][] visited) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
//            return;
//        }
//        cur += board[i][j];
//        if (!trie.hasPerfix(cur)) return;
//        if (trie.hasWord(cur)) {
//            res.add(cur);
//            return;
//        }
//        visited[i][j] = true;
//        DFS(board, i - 1, j, res, cur, trie, visited);
//        DFS(board, i + 1, j, res, cur, trie, visited);
//        DFS(board, i, j - 1, res, cur, trie, visited);
//        DFS(board, i, j + 1, res, cur, trie, visited);
//        visited[i][j] = false;
//        return;
//    }


//    /**
//     * Airbnb - Find the path that contains most words and print the path
//     *
//     * similar to lc212, DFS + trie
//     *
//     * should not return when find a word!
//     *
//     */
//    public void DFS_findMaxPath(Set<String> dict, List<List<int[]>> curPath, List<int[]> tmpPath, char[][] board, int i, int j,
//                                List<String> res, String cur, Trie trie, boolean[][] visited) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
//            return;
//        }
//        cur += board[i][j];
//        if (!trie.hasPerfix(cur)) return;
//
//        int[] tmp = new int[]{i, j};
//        tmpPath.add(tmp);
//
//        if (trie.hasWord(cur) && dict.contains(cur)) {
//            res.add(cur);
//            dict.remove(cur);
//            cur = "";
//            curPath.add(tmpPath);
//            tmpPath = new ArrayList<>();
//        }
//        visited[i][j] = true;
//        DFS_findMaxPath(dict, curPath, tmpPath, board, i - 1, j, res, cur, trie, visited);
//        DFS_findMaxPath(dict, curPath, tmpPath, board, i + 1, j, res, cur, trie, visited);
//        DFS_findMaxPath(dict, curPath, tmpPath, board, i, j - 1, res, cur, trie, visited);
//        DFS_findMaxPath(dict, curPath, tmpPath, board, i, j + 1, res, cur, trie, visited);
//        visited[i][j] = false;
//        return;
//    }



    public void findWordsII(char[][] board, String[] words) {
        Trie trie = new Trie();
        int row = board.length;
        int col = board[0].length;
        List<String> res = new LinkedList<>();

        for (String word: words) {
            trie.insert(word);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                search(board, visited, i, j, res, trie, new LinkedList<>());
            }
        }

        for (String s: res) {
            System.out.println(s);
        }
        return;
    }

    public void search(char[][] board, boolean[][] visited, int m, int n, List<String> res, Trie trie, List<String> words) {
        int row = board.length;
        int col = board[0].length;
        for (int i = m; i < row; i++) {
            for (int j = n; j < col; j++) {
                List<List<int[]>> nextIndexes = new LinkedList<>();
                List<int[]> path = new LinkedList<>();

                // find words that start from cur position
                DFS_findMaxWords(board, visited, i, j, "", trie, nextIndexes, path);

                for (List<int[]> next: nextIndexes) {
                    String word = "";
                    for (int[] nn: next) {
                        word += board[nn[0]][nn[1]];
                        visited[nn[0]][nn[1]] = true;
                    }
                    words.add(word);
                    if (words.size() > res.size()) {
                        res.clear();
                        res.addAll(words);
                    }
                    search(board, visited, i, j, res, trie, words);

                    for (int[] nn: next) {
                        visited[nn[0]][nn[1]] = false;
                    }
                    words.remove(words.size() - 1);
                }
            }
            n = 0;
        }
        return;
    }

    public void DFS_findMaxWords(char[][] board, boolean[][] visited,
                                 int i, int j, String cur, Trie trie, List<List<int[]>> nextIndexes, List<int[]> path) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        cur += board[i][j];
        if (!trie.hasPerfix(cur)) return;

        if (trie.hasWord(cur)) {
            List<int[]> tmp = new ArrayList<>(path);
            tmp.add(new int[]{i,j});
            nextIndexes.add(tmp);
            return;
        }
        visited[i][j] = true;
        path.add(new int[]{i,j});
        DFS_findMaxWords(board, visited, i + 1, j, cur, trie, nextIndexes, path);
        DFS_findMaxWords(board, visited, i - 1, j, cur, trie, nextIndexes, path);
        DFS_findMaxWords(board, visited, i , j + 1, cur, trie, nextIndexes, path);
        DFS_findMaxWords(board, visited, i, j - 1, cur, trie, nextIndexes, path);
        visited[i][j] = false;
        path.remove(path.size() - 1);
        return;
    }


    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'a','t','g','u'},{'i','h','k','r'},{'i','f','l','y'}};
        String[] words = {"run","fly","oath","agk","oatg"};
        new BoggleGame_24().findWordsII(board, words);
    }
}
