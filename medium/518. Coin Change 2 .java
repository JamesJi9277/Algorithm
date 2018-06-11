class Solution {
    int count = 0;
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return count;
        }
        Arrays.sort(coins);
        helper(amount, coins, 0);
        return count;
    }
    private void helper(int amount, int[] coins, int start) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            count++;
            return;
        }
        for (int i = start; i < coins.length; i++) {
            helper(amount - coins[i], coins, i);
        }
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount && j + coins[i] <= amount; j++) {
                dp[j + coins[i]] += dp[j];
            }
        }
        return dp[amount];
    }
}