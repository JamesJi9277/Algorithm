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