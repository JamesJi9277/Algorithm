class Solution {
    public boolean stoneGame(int[] piles) {
        Integer[][] dp = new Integer[piles.length][piles.length];
        return helper(piles, 0, piles.length - 1, dp) >= 0;
        
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