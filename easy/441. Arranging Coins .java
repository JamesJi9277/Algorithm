class Solution {
    public int arrangeCoins(int n) {
        int stair = 0;
        if (n < 1) {
            return stair;
        }
        while (n >= stair) {
            n -= stair;
            stair++;
        }
        return --stair;
    }
}