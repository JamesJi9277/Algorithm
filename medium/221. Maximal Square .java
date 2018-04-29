class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 这一题trick的地方是在于构造DP的方式还是一样
        // 但是在判断的时候是取最小值，代表最短的边长度
        int max = 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                res[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                res[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                if (matrix[i][j] == '1') {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                    max = Math.max(max, res[i][j]);
                }
            }
        }
        return max * max;
    }
}