class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] count = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(i, j, matrix, count, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    private int helper(int i, int j, int[][] matrix, int[][] count, int min) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= min) {
            return 0;
        }
        
        if (count[i][j] > 0) {
            return count[i][j];
        }
        min = matrix[i][j];
        int res = 0;
        int a = helper(i + 1, j, matrix, count, min) + 1;
        int b = helper(i - 1, j, matrix, count, min) + 1;
        int c = helper(i, j + 1, matrix, count, min) + 1;
        int d = helper(i, j - 1, matrix, count, min) + 1;
        res = Math.max(a, Math.max(b, Math.max(c, d)));
        count[i][j] = res;
        return res;
    }
}
// 这是一个好题，tricky的地方在于我并不去要去记录visited，当我发现比当前元素小的时候就自动的返回了
// 并且利用一个数组去记录已经走过的结果可以避免重复运算
// bug free
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