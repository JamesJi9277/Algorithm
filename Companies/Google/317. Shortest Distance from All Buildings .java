class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];
        int house = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    house++;
                    helper(grid, i, j, m, n, dist, count);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == house) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void helper(int[][] grid, int row, int col, int m, int n, int[][] dist, int[][] count) {
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (grid[temp[0]][temp[1]] == 0) {
                    count[temp[0]][temp[1]]++;
                    dist[temp[0]][temp[1]] += step;
                }
                for (int[] dir : directions) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
    }
}