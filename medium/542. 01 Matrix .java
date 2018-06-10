class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] leftUp = {{0, -1}, {-1, 0}};
        int[][] rightDown = {{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] <= 1) {
                    continue;
                }
                int dist = res[i][j];
                for (int[] dir : leftUp) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (outside(x, y, matrix) || res[x][y] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist = Math.min(dist, res[x][y] + 1);
                }
                res[i][j] = dist;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i][j] <= 1) {
                    continue;
                }
                int dist = res[i][j];
                for (int[] dir : rightDown) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (outside(x, y, matrix) || res[x][y] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist = Math.min(dist, res[x][y] + 1);
                }
                res[i][j] = dist;
            }
        }
        return res;
    }
    private boolean outside(int i, int j, int[][] matrix) {
        return (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length);
    }
}


public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return matrix;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length ||
                    matrix[x][y] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                queue.offer(new int[]{x, y});
                matrix[x][y] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}