package FullTime.Facebook;

public class ReadNCharactersGivenRead4 {

    // read4 API
    public int read4(char[] buf) {
        return 4;
    }

    // ReadNCharactersGivenRead4I: readI is called once
    public int readI(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            char[] tmp = new char[4];
            int size = read4(tmp);
            if (size == 0) break;
            for (int j = 0; j < size; j++) {
                buf[i++] = tmp[j];
                if (i == n) break;
            }
        }
        return i;
    }


    // ReadNCharactersGivenRead4II: readII is called multiple times
    int prevIndex = 0, prevSize = 0;
    char[] prevBuf = new char[4];
    public int readII(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (prevIndex < prevSize) {
                buf[i++] = prevBuf[prevIndex++];
            } else {
                int size = read4(prevBuf);
                if (size == 0) break;
                prevSize = size;
                prevIndex = 0;
            }
        }
        return i;
    }
}
