class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int p1 = oneTime(prices, 0, prices.length - 1);
        int p2 = twoTimes(prices);
        return Math.max(p1, p2);
    }
    private int twoTimes(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, oneTime(prices, 0, i) + oneTime(prices, i + 1, prices.length - 1));
        }
        return res;
    }
    private int oneTime(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems


class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length / 2 <= 2) {
            return greedy(prices);
        }
        int length = prices.length;
        int[][] global = new int[length + 1][length + 1];
        int[][] mustSell = new int[length + 1][length + 1];
        global[0][0] = 0;
        mustSell[0][0] = 0;
        for (int i = 1; i <= 2; i++) {
            mustSell[0][i] = 0;
            global[0][i] = 0;
        }
        for (int i = 1; i < length; i++) {
            mustSell[i][0] = 0;
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                mustSell[i][j] = Math.max(mustSell[i - 1][j] + diff, global[i - 1][j - 1] + diff);
                global[i][j] = Math.max(global[i - 1][j], mustSell[i][j]);
            }
        }
        return global[length - 1][2];
    }
    private int greedy(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]) {
                max += (nums[i + 1] - nums[i]);
            }
        }
        return max;
    } 
}