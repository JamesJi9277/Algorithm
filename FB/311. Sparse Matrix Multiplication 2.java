class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = helper(A, B, i, j);
            }
        }
        return res;
    }
    private int helper(int[][] A, int[][] B, int x, int y) {
        int sum = 0;
        for (int i = 0; i < A[0].length; i++) {
            sum += (A[x][i] * B[i][y]);
        }
        return sum;
    }
}