class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 999;
        boolean[] dup = new boolean[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int temp = helper(grid, i, j, new HashSet<Integer>(), dup);
                    if (!dup[0]) {
                        max = Math.min(max, temp);
                    }
                }
            }
        }
        return max;
    }
    private int helper(int[][] grid, int x, int y, Set<Integer> set, boolean[] dup) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || dup[0]) {
            return 0;
        }
        if (set.contains(grid[x][y])) {
            dup[0] = true;
        }
        set.add(grid[x][y]);
        int temp = grid[x][y];
        grid[x][y] = 0;
        return temp + helper(grid, x + 1, y, set, dup) + helper(grid, x - 1, y, set, dup) + helper(grid, x, y + 1, set, dup) + helper(grid, x, y - 1, set, dup);
    }
}