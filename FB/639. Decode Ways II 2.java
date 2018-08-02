class Solution {
    private static final long mod = 1000000007;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = helper(s.charAt(0));
        for (int i = 2; i < dp.length; i++) {
            long one = helper(s.charAt(i - 1)) * dp[i - 1];
            long two = helper(s.charAt(i - 2), s.charAt(i - 1)) * dp[i - 2];
            dp[i] = add(one, two);
        }
        return (int)dp[s.length()];
    }
    private long add(long num1, long num2) {
        return (num1 % mod + num2 % mod) % mod;
    }
    private long helper(char c) {
        return c == '*' ? 9 : (c == '0') ? 0 : 1;
    }
    private long helper(char a, char b) {
        if (a == '*' && b == '*') {
            return 15;
        } else if (a == '*') {
            return (b > '6') ? 1 : 2;
        } else if (b == '*') {
            return (a == '1') ? 9 : (a == '2') ? 6 : 0;
        } else {
            int temp = Integer.valueOf("" + a + b);
            return (temp >= 10 && temp <= 26) ? 1 : 0;
        }
    }
}