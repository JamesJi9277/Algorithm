class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            // n is even
            if ((n & 1) == 0) {
                n = (n >>> 1);
            // n == 3 or n-- will reduce number of 1
            // if (n >>> 1) & 1 == 1, means it will bring more 1
            } else if ((n == 3) || ((n >>> 1) & 1) == 0) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
}