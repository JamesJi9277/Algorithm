class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }
        return max;
    }
    private int helper(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + helper(grid, row + 1, col) 
            + helper(grid, row - 1, col) 
            + helper(grid, row, col + 1) 
            + helper(grid, row, col - 1);
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }
        return max;
    }
    private int helper(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + 
        helper(grid, x + 1, y)
        + helper(grid, x - 1, y)
        + helper(grid, x, y + 1)
        + helper(grid, x, y - 1);
    }
}