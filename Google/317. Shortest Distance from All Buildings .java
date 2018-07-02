class Solution {
    static final int[][] directions = new int[][]{{0,1}, {1,0}, {0, -1}, {-1,0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // total distance to all reachable houses from i, j
        int[][] dist = new int[m][n];
        // total numbrr of houses reachable from i,j
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
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == 0) {
                    // number of house reachable from start point
                    count[x][y]++;
                    dist[x][y] += steps;
                }
                for (int[] dir : directions) {
                    int k1 = x + dir[0];
                    int k2 = y + dir[1];
                    if (k1 >= 0 && k1 < m && k2 >= 0 && k2 < n && grid[k1][k2] == 0 && !visited[k1][k2]) {
                        visited[k1][k2] = true;
                        queue.offer(new int[]{k1, k2});
                    }
                }
            }
            steps++;
        }
    }
}


class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];
        int houses = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses++;
                    bfs(grid, dist, count, i, j, m, n);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == houses) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void bfs(int[][] grid, int[][] dist, int[][] count, int row, int col, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] visited = new int[m][n];
        visited[row][col] = 1;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == 0) {
                    count[x][y]++;
                    dist[x][y] += steps;
                }
                for (int[] dir : directions) {
                    int k1 = x + dir[0];
                    int k2 = y + dir[1];
                    if (k1 >= 0 && k1 < m && k2 >= 0 && k2 < n && grid[k1][k2] == 0 && visited[k1][k2] == 0) {
                        visited[k1][k2] = 1;
                        queue.offer(new int[]{k1, k2});
                    }
                }
            }
            steps++;
        }
    }
}