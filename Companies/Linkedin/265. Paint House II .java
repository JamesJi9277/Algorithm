class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = getMin(dp[i - 1], j) + costs[i][j];
            }
        }
        return getMin(dp[n - 1], -1);
    }
    private int getMin(int[] nums, int color) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (color == -1 || i != color) {
                min = Math.min(min, nums[i]);
            }
        }
        return min;
    }
}