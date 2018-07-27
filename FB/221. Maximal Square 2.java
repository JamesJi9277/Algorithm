class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}