/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//in this problem, the n is fixed
// program will read n repeatly until read the end
      // what is end, end is count < 4 or index == n
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) {
                break;
            }
        }
        return index;
    }
}