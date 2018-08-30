class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] dp = new boolean[n];
        for (int i = 2; i < n; i++) {
            dp[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (dp[i]) {
                for (int j = i + i; j < n; j += i) {
                    dp[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < dp.length; i++) {
            if (dp[i]) {
                count++;
            }
        }
        return count;
    }
}