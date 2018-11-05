class Solution {
    long mod = 1337;
    public int largestPalindrome(int n) {
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10;
        for (long i = max; i > min; i--) {
            long right = Long.parseLong(new StringBuffer("" + i).reverse().toString());
            long res = i * (max + 1) + right;
            for (long j = max; j * j >= res; j--) {
                if (res % j == 0) {
                    return (int)(res % mod);
                }
            }
        }
        return 9;
    }
}