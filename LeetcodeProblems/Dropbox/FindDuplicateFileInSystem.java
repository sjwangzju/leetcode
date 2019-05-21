package Dropbox;

import java.io.*;
import java.util.*;

public class FindDuplicateFileInSystem {

    /****************************************************************************************/
    // key   => file content
    // value => files with same content
    public List<List<String>> findDuplicate(String path) throws Exception {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        List<String> filesList = readFiles_DFS(path);
        for (String f: filesList) {
            File file = new File(f);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder s = new StringBuilder();
            String curStr = br.readLine();

            while (curStr != null) {
                s.append(curStr);
                curStr = br.readLine();
            }

            if (!map.containsKey(s.toString())) {
                map.put(s.toString(), new LinkedList<>());
            }
            map.get(s.toString()).add(f);
        }
        for (String key: map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }


    // FOLLOWUP 1
    /****************************************************************************************/
    // key   => hashing: MD5
    // value => files with same hashcode
    public List<List<String>> findDuplicateI(String path) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        List<String> filesList = readFiles_DFS(path);
        for (String f: filesList) {
            File curFile = new File(f);

            // hashing each file and put into the map
            String curHash = MD5(curFile);
            if (!map.containsKey(curHash)) {
                map.put(curHash, new LinkedList<>());
            }
            map.get(curHash).add(f);
        }

        for (String key: map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }

    // problem: MD5 is slow if each file is very large
    // improve: use metadata of the file to hash the files, then use MD5 to hash the files with same metadata


    // FOLLOWUP 2
    /****************************************************************************************/
    // group by size
    // find duplicate MD5 hash in each group
    public List<List<String>> findDuplicateII(String path) {
        List<List<String>> res = new LinkedList<>();
        Map<Long, List<String>> lenMap = new LinkedHashMap<>();

        // group all files by size
        List<String> fileList = readFiles_DFS(path);
        for (String file: fileList) {
            File curFile = new File(file);
            long curLen = curFile.length();
            if (!lenMap.containsKey(curLen)) {
                lenMap.put(curLen, new LinkedList<>());
            }
            lenMap.get(curLen).add(file);
        }

        // find duplicate files in the group of same size
        for (Long l: lenMap.keySet()) {
            Map<String, List<String>> MD5map = new HashMap<>();
            List<String> list = lenMap.get(l);

            for (String s: list) {
                File curF = new File(s);
                String curHash = MD5(curF);
                if (!MD5map.containsKey(curHash)) {
                    MD5map.put(curHash, new LinkedList<>());
                }
                MD5map.get(curHash).add(s);
            }

            for (String key: MD5map.keySet()) {
                List<String> curList = MD5map.get(key);
                if (curList.size() > 1) {
                    res.add(curList);
                }
            }
        }

        return res;
    }


    // FOLLOWUP 3
    /****************************************************************************************/
    // rolling hashing: divide files into blocks of 1kb

    public void rollingHashing(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int res = fis.read(buffer);

        while (res != -1) {
            // hashing each block
            String hash = getMD5(buffer);
            res = fis.read(buffer);
        }
    }



    // DFS
    /****************************************************************************************/
    public List<String> readFiles_DFS(String path) {
        List<String> res = new LinkedList<>();
        dfsHelper(path, res);
        return res;
    }

    public void dfsHelper(String path, List<String> res) {
        File directory = new File(path);
        if (directory.exists()) {
            // get all files under current directory
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {
                for (File f: files) {
                    if (f.isDirectory()) {
                        dfsHelper(f.getAbsolutePath(), res);
                    } else {
                        res.add(f.getAbsolutePath());
//                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("no such directory");
        }
    }


    // BFS
    /****************************************************************************************/
    public List<String> readFiles_BFS(String path) {
        List<String> res = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        q.offer(path);
        while (!q.isEmpty()) {
            String cur = q.poll();
            File directory = new File(cur);
            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null && files.length > 0) {
                    for (File f: files) {
                        if (f.isDirectory()) {
                            q.offer(f.getAbsolutePath());
                        } else {
                            res.add(f.getAbsolutePath());
//                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("no such directory");
            }
        }
        return res;
    }


    //////////////// MD5 ////////////////////
    public String MD5(File file) {
       return file.getAbsolutePath();
    }

    public String getMD5(byte[] file) {
        return "";
    }



    /****************************************************************************************/
    public static void main(String[] args) throws Exception {
        String path = "/Users/Coco/Desktop/internship/Interview/Dropbox/files/";

        System.out.println("BFS:");
        System.out.println(new FindDuplicateFileInSystem().findDuplicate(path));

//        System.out.println("DFS:");
//        System.out.println(new FindDuplicateFileInSystem().readFiles_DFS(path));

    }
}
