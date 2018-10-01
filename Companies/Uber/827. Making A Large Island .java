class Solution {
    public int largestIsland(int[][] grid) {
        int max = 0;
        if (grid == null) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = helper(grid);
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, helper(grid));
                    grid[i][j] = 0;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
    private int helper(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getSum(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return max;
    }
    private int getSum(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = getSum(grid, i + 1, j, visited) + 
            getSum(grid, i - 1, j, visited) + 
            getSum(grid, i, j + 1, visited) + 
            getSum(grid, i, j - 1, visited) + 1;
        return res;
    }
}