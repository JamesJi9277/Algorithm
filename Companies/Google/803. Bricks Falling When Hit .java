class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || grid.length == 0) {
            return res;
        }
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        Set<Integer> nonDrop = new HashSet<>();
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                helper(grid, 0, i, nonDrop);
            }
        }
        
        for (int i = hits.length - 1; i >= 0; i--) {
            int size = nonDrop.size();
            int[] hit = hits[i];
            if (++grid[hit[0]][hit[1]] == 1) {
                if ((hit[0] > 0 && nonDrop.contains((hit[0] - 1) * n + hit[1])) 
                    || (hit[0] < m - 1 && nonDrop.contains((hit[0] + 1) * n + hit[1])) 
                    || (hit[1] > 0 && nonDrop.contains(hit[0] * n + hit[1] - 1)) 
                    || (hit[1] < n - 1 && nonDrop.contains(hit[0] * n + hit[1] + 1)) 
                    || (hit[0] == 0)) {
                    helper(grid, hit[0], hit[1], nonDrop);
                    res[i] = nonDrop.size() - size - 1;
                }
            }
        }
        return res;
    }
    private void helper(int[][] grid, int x, int y, Set<Integer> connected) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        if (!connected.add(x * grid[0].length + y)) {
            return;
        }
        helper(grid, x + 1, y, connected);
        helper(grid, x - 1, y, connected);
        helper(grid, x, y + 1, connected);
        helper(grid, x, y - 1, connected);
    }
}