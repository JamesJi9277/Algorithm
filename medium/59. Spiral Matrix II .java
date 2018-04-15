class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n < 1) {
            return res;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int num = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = num++;
            }
            colEnd--;
            // 存在的情况下才可以向左走
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = num++;
                }
            }
            rowEnd--;
            // 存在的情况下才可以向上走
            if (colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return res;
    }
}