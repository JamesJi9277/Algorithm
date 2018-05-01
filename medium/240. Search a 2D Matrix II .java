class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}