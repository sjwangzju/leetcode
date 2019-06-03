package FullTime.FB;

/**
 * use class variables to store buf data
 */
public class LC158_ReadNCharactersGivenRead4_H {

    // prevBuf used to save the data from last call
    private int prevIndex = 0;
    private int prevSize = 0;
    private char[] prevBuf = new char[4];

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
