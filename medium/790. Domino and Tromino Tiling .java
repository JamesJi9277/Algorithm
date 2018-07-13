class Solution {
    private static final int mod = 1000000007;
    public int numTilings(int N) {
        int[] dp = new int[N + 10];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] * 2 % mod + dp[i - 3] % mod;
            dp[i] %= mod;
        }
        return dp[N];
    }
}

class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    public int numTilings(int N) {
        int[] res = new int[N + 5];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 5;
        for (int i = 4; i < res.length; i++) {
            res[i] = 2 * res[i - 1] % mod + res[i - 3] % mod;
            res[i] %= mod;
        }
        return res[N];
    }
}