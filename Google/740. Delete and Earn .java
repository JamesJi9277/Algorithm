class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // given nums[i] range is 1-10000
        // same as can not rob neighbor
        int[] dp = new int[10001];
        for (int i : nums) {
            dp[i] += i;
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        return dp[dp.length - 1];
    }
}