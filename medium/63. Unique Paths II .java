class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        boolean hasObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                hasObstacle = true;
            }
            if (hasObstacle) {
                res[i][0] = 0;
            } else {
                res[i][0] = 1;
            }
        }
        hasObstacle = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                hasObstacle = true;
            }
            if (hasObstacle) {
                res[0][j] = 0;
            } else {
                res[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}