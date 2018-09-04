/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int pointer = 0;
    int count = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                count = read4(temp);
            }
            while (index < n && pointer < count) {
                buf[index++] = temp[pointer++];
            }
            if (index == n || count == 0) {
                break;
            }
            if (pointer == count) {
                pointer = 0;
            }
        }
        return index;
    }
}