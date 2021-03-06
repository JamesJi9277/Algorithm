class Solution {
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }   
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = i;
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}