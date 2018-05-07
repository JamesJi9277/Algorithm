class Solution {
    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }
        return helper(n, n, new Double[n + 1][n + 1]);
    }
    private int helper(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (memo[a][b] != null) {
            return memo[a][b];
        }
        int[] serveA = {100, 75, 50, 25};
        int[] serveB = {0, 25, 50, 100};
        memp[a][b] = 0.0;
        for (int i = 0; i < 4; i++) {
            memo[a][b] += helper(a - serveA[i], b - serveB[i], memo);
        }
        return memo[a][b] * 0.25;
    }
}