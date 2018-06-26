class NumMatrix {

    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

public class NumMatrix {
    int[][] copy;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        copy = new int[m][n];
        copy[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++) {
            copy[i][0] = matrix[i][0] + copy[i - 1][0];
        }
        for(int j = 1; j < n; j++) {
            copy[0][j] = matrix[0][j] + copy[0][j - 1];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                copy[i][j] = matrix[i][j] + copy[i - 1][j] + copy[i][j -  1] - copy[i - 1][j - 1];
            }
        } 
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(copy == null)
            return 0;
        if(row1 == 0 && col1 == 0)
            return copy[row2][col2];
        if(row1 == 0)
            return copy[row2][col2] - copy[row2][col1 - 1];
        if(col1 == 0)
            return copy[row2][col2]-copy[row1 - 1][col2];
        return copy[row2][col2] - copy[row1 - 1][col2] - copy[row2][col1 - 1] + copy[row1 - 1][col1 - 1];
    }
}