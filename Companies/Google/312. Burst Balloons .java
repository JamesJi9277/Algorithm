class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        return helper(nums, dp, 0, nums.length - 1);
    }
    private int helper(int[] nums, int[][] dp, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        for (int i = start; i <= end; i++) {
            dp[start][end] = Math.max(dp[start][end], helper(nums, dp, start, i - 1) + helper(nums, dp, i + 1, end) + getNum(nums, start - 1) * getNum(nums, end + 1) * nums[i]);
        }
        return dp[start][end];
    }
    private int getNum(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return 1;
        } else {
            return nums[index];
        }
    }
}