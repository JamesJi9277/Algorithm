class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int level = matrix.length / 2;
        for (int i = 0; i < level; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - 1 - i][matrix.length - j - 1];
                matrix[matrix.length - 1 - i][matrix.length - j - 1] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
        return;
    }
}