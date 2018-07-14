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