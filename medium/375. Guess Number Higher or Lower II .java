class Solution {
    public int getMoneyAmount(int n) {
        if(n<=1) return 0;
        int[][] dp = new int[n+1][n+1];
        recursion(dp, 1, n);
        return dp[1][n];
    }
    
    private int recursion(int[][] dp, int start, int end) {
        if(start>=end) return 0;
        if(dp[start][end]!=0) return dp[start][end];
        int minCost = Integer.MAX_VALUE;
        for(int i = (start + end)>>>1, left = 0, right = 1; i <= end && left<right; i++) { // start from mid, and if left part is equal to or greater than right part we could stop scanning
            left = recursion(dp, start, i-1);
            right = recursion(dp, i+1, end);
            int cost = i + Math.max(left, right);
            minCost = Math.min(minCost, cost);
        }
        dp[start][end] = minCost;
        return minCost;
    }
}