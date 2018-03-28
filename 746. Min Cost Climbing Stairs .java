// 找到DP方程很重要
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] res = new int[length + 1];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i <= length; i++) {
            int c = (i == length) ? 0 : cost[i];
            res[i] = Math.min(res[i - 1] + c, res[i - 2] + c);
        }
        return res[length];
    }
}