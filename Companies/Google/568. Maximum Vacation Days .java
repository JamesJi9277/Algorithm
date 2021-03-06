class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int res = 0;
        int[][] dp = new int[K][N]; // 第K周在第N个城市的最大假期
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                int maxDays = Integer.MIN_VALUE;
                if (i == 0) {
                    if (j == 0 || flights[0][j] == 1) {
                        maxDays = days[j][0];
                    }
                } else {
                    for (int k = 0; k < N; k++) {
                        if (k == j || flights[k][j] == 1) {
                            //在所有可能到到达的选择中找到一个最大值
                            maxDays = Math.max(maxDays, dp[i - 1][k] + days[j][i]);
                        }
                    }
                }
                dp[i][j] = maxDays;
            }
        }
        
        for (int i : dp[K-1]) {
            res = Math.max(res, i);
        }
        return res;
    }
}


int n = flights.length;
        int k = days[0].length;
        int res = 0;
        int[][] dp = new int[k][n];//第K周在第N个城市的最大假期
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                int max = Integer.MIN_VALUE;
                if (i == 0) {
                    if (j == 0 || flights[0][j] == 1) {
                        max = days[j][0];
                    }
                } else {
                    for (int m = 0; m < n; m++) {
                        if (m == j || flights[m][j] == 1) {
                            max = Math.max(max, dp[i - 1][m] + days[j][i]);//maximum days you could take vacation in the city i in the week j.
                        }
                    }
                }
                dp[i][j] = max;
            }
        }
        for (int i : dp[k - 1]) {
            res = Math.max(res, i);
        }
        return res;