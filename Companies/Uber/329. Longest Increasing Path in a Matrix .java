class Solution {
    int max = 1;
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper(matrix, visited, i, j, 1);
            }
        }
        return max;
    }
    private void helper(int[][] matrix, boolean[][] visited, int i, int j, int len) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return;
        }
        max = Math.max(max, len);
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] > matrix[i][j]) {
                visited[i][j] = true;
                helper(matrix, visited, x, y, len + 1);
                visited[i][j] = false;
            }
        }
    }
}


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j, cache, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    private int helper(int[][] matrix, int row, int col, int[][] cache, int min) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= min) {
            return 0;
        }
        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        min = matrix[row][col];
        int res = 0;
        int a = helper(matrix, row + 1, col, cache, min) + 1;
        int b = helper(matrix, row - 1, col, cache, min) + 1;
        int c = helper(matrix, row, col + 1, cache, min) + 1;
        int d = helper(matrix, row, col - 1, cache, min) + 1;
        res = Math.max(Math.max(a, b), Math.max(c, d));
        cache[row][col] = res;
        return res;
    }
}