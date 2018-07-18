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