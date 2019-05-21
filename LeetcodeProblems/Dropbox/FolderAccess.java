package Dropbox;

import java.util.*;

public class FolderAccess {

    public static class Folder {
        Map<String, String> parent;
        Set<String> access;

        public Folder(Map<String, String> parent, Set<String> access) {
            this.parent = parent;
            this.access = access;
        }

        // time: O(logN)
        public boolean hasAccess(String folder) {
            String curFolder = folder;
            while (curFolder != null) {
                if (access.contains(curFolder)) {
                    return true;
                }
                curFolder = parent.get(curFolder);
            }
            return false;
        }


        // time: O(MlogN)
        public void fixRedundantAccessI(Set<String> access) {
            Set<String> redundant = new HashSet<>();
            for (String ac: access) {
                String curParent = parent.get(ac);
                while (curParent != null) {
                    if (access.contains(curParent)) {
                        redundant.add(ac);
                        break;
                    }
                    curParent = parent.get(curParent);
                }
            }
            access.removeAll(redundant);
            return;
        }
    }

    public static void main(String[] args) {
        Map<String, String> parent = new HashMap<>();
        parent.put("B","A");
        parent.put("C","B");
        parent.put("D","C");
        parent.put("E","D");
        parent.put("F","D");

        Set<String> set = new HashSet<>();
        set.add("C");
        set.add("E");
        set.add("F");

        Folder folder = new Folder(parent, set);
        System.out.println(folder.hasAccess("B"));
        System.out.println(folder.hasAccess("C"));
        System.out.println(folder.hasAccess("F"));

        folder.fixRedundantAccessI(set);
        System.out.println(set);
    }
}
