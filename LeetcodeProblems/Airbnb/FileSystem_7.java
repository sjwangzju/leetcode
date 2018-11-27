package Airbnb;

import java.util.HashMap;
import java.util.Map;

/**
 * File System. 经典系统设计题 OOD
 * callback function
 * new Runnable() {}
 */
public class FileSystem_7 {

    public Map<String, Integer> fileMap;
    public Map<String, Runnable> callbackMap;

    public FileSystem_7() {
        this.fileMap = new HashMap<>();
        this.callbackMap = new HashMap<>();
        fileMap.put("", 0);
    }

    public boolean create(String path, int value) {
        if (fileMap.containsKey(path)) {
            return false;
        }
        int index = path.lastIndexOf("/");
        String s = path.substring(0, index);
        if (fileMap.containsKey(s)) {
            fileMap.put(path, value);
            String tmp = s;
            while (tmp.length() > 0) {
                if (callbackMap.containsKey(tmp)) {
                    callbackMap.get(tmp).run();
                }
                tmp = tmp.substring(0, tmp.lastIndexOf("/"));
            }
            return true;
        }
        return false;
    }

    public boolean set_value(String path, Integer value) {
        if (fileMap.containsKey(path)) {
            fileMap.put(path, value);
            return true;
        }
        return false;
    }

    public Integer get_value(String path) {
        return fileMap.get(path);
    }

    public boolean watch(String path, Runnable run) {
        if (fileMap.containsKey(path)) {
            callbackMap.put(path, run);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FileSystem_7 fileSystem = new FileSystem_7();
        String path1 = "/a";
        String path2 = "/a/b";
        String path3 = "/c/b";
        String path4 = "/a/b/c";

        fileSystem.create(path1, 1);
        fileSystem.set_value(path1, 2);
        System.out.println(fileSystem.get_value(path1));

        fileSystem.watch(path1, new Runnable() {
            @Override
            public void run() {
                System.out.println("i'm /a");
            }
        });

        fileSystem.create(path2, 10);
        System.out.println(fileSystem.get_value(path2));

        fileSystem.watch(path2, new Runnable() {
            @Override
            public void run() {
                System.out.println("i'm /a/b");
            }
        });

        fileSystem.create(path3, 10);
        System.out.println(fileSystem.get_value(path3));

        fileSystem.create(path4, 10);

    }
}
