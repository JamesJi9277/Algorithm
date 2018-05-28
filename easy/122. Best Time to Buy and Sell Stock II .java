class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }


class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int t10 = 0;
        int t11 = Integer.MIN_VALUE;
        int t20 = 0;
        int t21 = Integer.MIN_VALUE;
        for (int price : prices) {
            t10 = Math.max(t10, t11 + price);
            t11 = Math.max(t11, t10 - price);
            t20 = Math.max(t20, t11 + price);
            t21 = Math.max(t21, t10 - price);
        }
        return t20;
    }
}