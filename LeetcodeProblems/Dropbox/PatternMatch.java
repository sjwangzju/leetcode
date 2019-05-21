package Dropbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class PatternMatch {

    // time: O(M * N), M is the len of fileContent, N is the len of pattern
    // space: O(M)
    public boolean fileContains(String filePath, byte[] pattern) throws Exception {

        // read byte[] from file
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder s = new StringBuilder();
        String tmp = br.readLine();
        while (tmp != null) {
            s.append(tmp);
            tmp = br.readLine();
            if (tmp != null) s.append("\n");
        }
        byte[] fileContent = s.toString().getBytes();

        // compute hash
        int m = pattern.length;
        int n = fileContent.length;
        byte[] firstPart = Arrays.copyOfRange(fileContent, 0, m);
        RollingHash rollingHash = new RollingHash(firstPart);
        long patternHash = rollingHash.hash(pattern);


        for (int i = 0; i <= n - m; i++) {
            // compare hashcode of two byte arrays
            if (rollingHash.hashVal == patternHash) {

                //compare byte by byte to avoid collision
                int j = 0;
                while (j < m && pattern[j] == fileContent[i + j]) j++;
                if (j == m) return true;
            }

            // Rolling hash, recompute hash in O(1)
            if (i < n - m) {
                rollingHash.removeByte(fileContent[i]);
                rollingHash.addByte(fileContent[i + m]);
            }
        }
        return false;
    }

    // API
    public class RollingHash {
        long hashVal;

        public RollingHash(byte[] bytes) {
            this.hashVal = hash(bytes);
        }

        public long hash(byte[] bytes) {
            return 0;
        }

        public void addByte(byte b) {
            this.hashVal += b;
            return;
        }

        public void removeByte(byte b) {
            this.hashVal -= b;
            return;
        }
    }

    /****************************************************************************************/
    public static void main(String[] args) throws Exception {
        String filepath = "/Users/Coco/Desktop/internship/Interview/Dropbox/files/a/1.txt";
        String s = "abcd\nef";
        byte[] pattern = s.getBytes();
        System.out.println(new PatternMatch().fileContains(filepath, pattern));
    }
}
