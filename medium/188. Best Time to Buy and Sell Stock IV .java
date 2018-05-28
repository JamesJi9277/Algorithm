class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return greedy(prices);
        }
        int length = prices.length;
        int[][] mustSell = new int[length + 1][length + 1];
        int[][] global = new int[length + 1][length + 1];
        mustSell[0][0] = 0;
        global[0][0] = 0;
        for (int i = 0; i <= k; i++) {
            mustSell[0][i] = 0;
            global[0][i] = 0;
        }
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            mustSell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustSell[i][j] = Math.max(mustSell[i - 1][j] + diff, global[i - 1][j - 1] + diff);
                global[i][j] = Math.max(global[i - 1][j], mustSell[i][j]);
            }
        }
        return global[length - 1][k];
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