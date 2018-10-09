class Solution {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) {
            return false;
        }
        int[][] dp = new int[piles.length][piles.length];
        return helper(dp, piles, 0, piles.length - 1) >= 0;
    }
    private int helper(int[][] dp, int[] piles, int start, int end) {
        if (start == end) {
            return piles[start];
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        dp[start][end] = Math.max(piles[start] - helper(dp, piles, start + 1, end), piles[end] - helper(dp, piles, start, end - 1));
        return dp[start][end];
    }
}