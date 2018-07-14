class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int i = 0;
        int j = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = i;
            i = Math.max(i, j + price);
            j = Math.max(j, temp - fee - price);
        }
        return i;
    }
}

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        long tik0 = 0;
        long tik1 = Integer.MIN_VALUE;
        for (int price : prices) {
            long tik0_old = tik0;
            tik0 = Math.max(tik0, tik1 + price - fee);
            tik1 = Math.max(tik1, tik0_old - price);
        }
        return (int)tik0;
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0, buy = -prices[0];
        for (int price : prices) {
            int sellOld = sell;
            sell = Math.max(sell, buy + price - fee);
            buy = Math.max(buy, sellOld - price);
        }
        return sell;
    }
}