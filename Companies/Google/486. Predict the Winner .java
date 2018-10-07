class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        //The dp[i][j] saves how much more scores that the first-in-action player will get from i to j than the second player. First-in-action means whomever moves first. 
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
        return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }
    private int helper(int[] nums, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        dp[start][end] = Math.max(nums[start] - helper(nums, start + 1, end, dp), nums[end] - helper(nums, start, end - 1, dp));
        return dp[start][end];
    }
}