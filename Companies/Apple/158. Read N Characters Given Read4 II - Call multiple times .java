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
            if (pointer == count) {
                pointer = 0;
            }
            if (n == index || count == 0) {
                break;
            }
        }
        return index;
    }
}