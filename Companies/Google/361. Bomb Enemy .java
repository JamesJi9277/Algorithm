class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] += count;
                } else {
                    count = 0;
                }
            }
            count = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] += count;
                } else {
                    count = 0;
                }
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == '0') {
                    dp[j][i] += count;
                } else if (grid[j][i] == 'E') {
                    count++;
                } else {
                    count = 0;
                }
            }
            count = 0;
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[j][i] == '0') {
                    dp[j][i] += count;
                    max = Math.max(max, dp[j][i]);
                } else if (grid[j][i] == 'E') {
                    count++;
                } else {
                    count = 0;
                }
            }
        }
        return max;
    }
}

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, count(grid, i, j));
                }
            }
        }
        return max;
    }
    private int count(char[][] grid, int x, int y) {
        int sum = 0;
        // go left
        int temp = y;
        while (temp >= 0) {
            if (grid[x][temp] == 'W') {
                break;
            }
            if (grid[x][temp] == 'E') {
                sum++;
            }
            temp--;
        }
        // go right
        temp = y + 1;
        while (temp < grid[0].length) {
            if (grid[x][temp] == 'W') {
                break;
            }
            if (grid[x][temp] == 'E') {
                sum++;
            }
            temp++;
        }
        // go up
        temp = x - 1;
        while (temp >= 0) {
            if (grid[temp][y] == 'W') {
                break;
            }
            if (grid[temp][y] == 'E') {
                sum++;
            }
            temp--;
        }
        temp = x + 1;
        while (temp < grid.length) {
            if (grid[temp][y] == 'W') {
                break;
            }
            if (grid[temp][y] == 'E') {
                sum++;
            }
            temp++;
        }
        return sum;
    }
}