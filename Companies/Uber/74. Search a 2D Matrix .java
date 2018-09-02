class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = matrix.length - 1;
        int right = 0;
        while (left >= 0 && right < matrix[0].length) {
            if (matrix[left][right] == target) {
                return true;
            } else if (matrix[left][right] > target) {
                left--;
            } else {
                right++;
            }
        }
        return false;
    }
}