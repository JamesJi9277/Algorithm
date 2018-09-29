class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double[][] dp = new double[nums.length + 1][k + 1];
        double cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            dp[i + 1][1] = cur / (i + 1);
        }
        return helper(nums, dp, nums.length, k);
    }
    private double helper(int[] nums, double[][] dp, int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        if (n < k) {
            return 0;
        }
        double cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            dp[n][k] = Math.max(dp[n][k], helper(nums, dp, i, k - 1) + cur / (n - i));
        }
        return dp[n][k];
    }
}