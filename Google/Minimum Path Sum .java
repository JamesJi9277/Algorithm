class Solution {
    public int minPathSum(int[][] grid) {
        // 这题比较基础
        // 贪心 + DP
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                dp[i][0] = grid[i][0];
            } else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (j == 0) {
                dp[0][j] = grid[0][j];
            } else {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}