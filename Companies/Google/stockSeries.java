// stockI
//只能买卖一次
//则找到最低点以及当前的值减去之前的最小值，这样来遍历一遍数组即可
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : prices) {
            min = Math.min(min, i);
            res = Math.max(res, i - min);
        }
        return res;
    }
}
// stockII
// can finish multiple transactions
// greedy, sell if we can make profit 
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res += (prices[i + 1] - prices[i]);
            }
        }
        return res;
    }
}

// can buy and sell two times
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
// with cooldown
/* Method 1, time O(n ^ 2), space O(n)
 * 1. update cooldown[i] is easy, cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
 * 2. for update sell[i], need to scan j from 0 -> i - 1, sell[i] will be the maximum of cooldown[j - 1] + (prices[i] - prices[j])
 * means cooldown at day j - 1, and buy at day j, and sell at day i;
 * 3. Pay attention to the boundy conditon, when j == 0, cooldown[j - 1] is not defined, use 0 instead
 * 4. then update the max profit along the way;
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] coolDown = new int[prices.length];
        int[] sell = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            coolDown[i] = Math.max(coolDown[i - 1], sell[i - 1]);
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    sell[i] = Math.max(sell[i], prices[i] - prices[j]);
                } else {
                    sell[i] = Math.max(sell[i], coolDown[j - 1] + prices[i] - prices[j]);
                }
            }
        }
        return Math.max(coolDown[prices.length - 1], sell[prices.length - 1]);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] coolDown = new int[prices.length];
        int[] sell = new int[prices.length];
        int diff = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            coolDown[i] = Math.max(coolDown[i - 1], sell[i - 1]);
            sell[i] = Math.max(sell[i], prices[i] + diff);
            diff = Math.max(diff, coolDown[i - 1] - prices[i]);
        }
        return Math.max(coolDown[prices.length - 1], sell[prices.length - 1]);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0, n = prices.length;
        int sell = 0;
        int cooldown = 0;
        int diff = -prices[0];
        for (int i = 1; i < n; i++) {
            int temp = cooldown;
            cooldown = Math.max(cooldown, sell);
            sell = Math.max(sell, prices[i] + diff);
            diff = Math.max(diff, temp - prices[i]);
            max = Math.max(max, cooldown);
            max = Math.max(max, sell);
        }
        return max;
    }
}


// with transaction fee
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

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 1] - prices[i], Math.max(buy[i - 1], buy[i - 1] - fee));
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }
}