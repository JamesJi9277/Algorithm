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