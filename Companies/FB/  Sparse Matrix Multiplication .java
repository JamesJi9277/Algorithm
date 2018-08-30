class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;
        int[][] res = new int[aRow][bCol];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = helper(A, B, i, j);
            }
        }
        return res;
    }
    private int helper(int[][] A, int[][] B, int aStart, int bEnd) {
        int res = 0;
        for (int i = 0; i < A[0].length; i++) {
            res += (A[aStart][i] * B[i][bEnd]);
        }
        return res;
    }
}