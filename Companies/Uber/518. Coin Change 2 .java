// can only do straight forward
// loop through coin and calculate dp[i + coin] += dp[i]
// otherwise will get re calculate
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount && i + coin <= amount; i++) {
                dp[i + coin] += dp[i];
            }
        }
        return dp[amount];
    }
}