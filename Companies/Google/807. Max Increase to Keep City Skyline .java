class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int max = findMax(grid, i, j);
                count += (max - grid[i][j]);
            }
        }
        return count;
    }
    private int findMax(int[][] grid, int row, int col) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            max1 = Math.max(max1, grid[i][col]);
        }
        for (int i = 0; i < grid[0].length; i++) {
            max2 = Math.max(max2, grid[row][i]);
        }
        return Math.min(max1, max2);
    }
}

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] col = new int[n], row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;
    }
}