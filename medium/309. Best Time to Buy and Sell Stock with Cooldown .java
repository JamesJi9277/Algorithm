https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[] max = new int[length];
        max[0] = 0;
        max[1] = Math.max(0, prices[1] - prices[0]);
        int buy = Math.max(0 - prices[0], 0 - prices[1]);
        for (int i = 2; i < length; i++) {
            max[i] = Math.max(max[i - 1], prices[i] + buy);
            buy = Math.max(buy, max[i - 2] - prices[i]);
        }
        return max[length - 1];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[length - 1][0];
    }
}