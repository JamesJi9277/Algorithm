class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        return helper(K, N, dp);
    }
    private int helper(int k, int n, int[][] dp) {
        if (n <= 1 || k == 1) {
            return n;
        }
        if (dp[k][n] > 0) {
            return dp[k][n];
        }
        int min = n;
        // for (int i = 1; i <= n; i++) {
        //     int left = helper(k - 1, i - 1, dp);
        //     int right = helper(k, n - i, dp);
        //     min = Math.min(min, Math.max(left, right) + 1);
        // }
        int low = 1;
        int high = n;
        while (low  + 1 < high) {
            int mid = low + (high - low) / 2;
            int left = helper(k - 1, mid - 1, dp);
            int right = helper(k, n - mid, dp);
            min = Math.min(min, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid;
            } else {
                high = mid;
            }
        }
        int left = helper(k - 1, low - 1, dp);
        int right = helper(k, n - low, dp);
        min = Math.min(min, Math.max(left, right) + 1);
        left = helper(k - 1,  high- 1, dp);
        right = helper(k, n - high, dp);
        min = Math.min(min, Math.max(left, right) + 1);
        dp[k][n] = min;
        return min;
    }
}