class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int canReach = 0;
        for (int i = 0; i <= canReach && i < nums.length; i++) {
            canReach = Math.max(canReach, nums[i] + i);
        }
        return canReach >= nums.length - 1;

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}