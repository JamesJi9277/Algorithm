class Solution {
    private void setZeroes1(int[][] matrix) {
        //方法一吃重新开辟一个数组然后扫描每一个元素
        //遇到0就进行set，但是这样会进行多次读写
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(res[i][j] == 0) {
                    setZero(matrix, i, j);
                }
            }
        }
        return;
    }
    
    private void setZero(int[][] matrix, int row, int col) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        return;
    }
    
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean setRow = false;
        boolean setCol = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                setRow = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                setCol = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(setRow) {//看清楚ij对应的行列并且看清楚boolean所对应的值
            for(int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if(setCol) {
            for(int j = 0; j < row; j++) {
                matrix[j][0] = 0;
            }
        }
        return;
    }
}