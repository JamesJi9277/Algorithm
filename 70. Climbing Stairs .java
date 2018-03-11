// 这一题是一个典型的DP问题
class Solution {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}