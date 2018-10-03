class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuffer sb = new StringBuffer();
                    helper(grid, i, j, sb, "o");
                    if (!set.contains(sb.toString())) {
                        set.add(sb.toString());
                    }
                }
            }
        }
        return set.size();
    }
    private void helper(int[][] grid, int i, int j, StringBuffer sb, String dir) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        sb.append(dir);
        grid[i][j] = 0;
        helper(grid, i + 1, j, sb, "d");
        helper(grid, i - 1, j, sb, "u");
        helper(grid, i, j + 1, sb, "r");
        helper(grid, i, j - 1, sb, "l");
        sb.append("f");
    }
}