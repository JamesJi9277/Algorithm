class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = getMin(dp[i - 1], j) + costs[i][j];
            }
        }
        return getMin(dp[dp.length - 1], Integer.MIN_VALUE);
    }
    private int getMin(int[] nums, int j) {
        int min = Integer.MAX_VALUE;
        if (j == Integer.MIN_VALUE) {
            for (int i : nums) {
                min = Math.min(min, i);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i == j) {
                    continue;
                }
                min = Math.min(min, nums[i]);
            }
        }
        return min;
    }
}