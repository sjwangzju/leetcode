package FullTime.FB;

/**
 * same as LC158
 */
public class LC157_ReadNCharactersGivenRead4_E {

    // prevBuf used to save the data from last call
    int prevIndex = 0;
    int prevSize = 0;
    char[] prevBuf = new char[4];

    public int read(char[] buf, int n) {
        int cnt = 0;
        while (cnt < n) {
            if (prevIndex < prevSize) {
                buf[cnt++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;

                // no more data to read
                if (prevSize == 0) {
                    break;
                }
            }
        }
        return cnt;
    }

    public int read4(char[] buf) {
        return 0;
    }

}
