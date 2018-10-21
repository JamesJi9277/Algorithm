class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                max = Math.max(max, Math.max(helper(A, B, i, j), helper(B, A, i, j)));
            }
        }
        return max;
    }
    private int helper(int[][] A, int[][] B, int rowOffSet, int colOffSet) {
        int sum = 0;
        for (int i = rowOffSet; i < A.length; i++) {
            for (int j = colOffSet; j < A[0].length; j++) {
                sum += A[i][j] * B[i - rowOffSet][j - colOffSet];
            }
        }
        return sum;
    }
}