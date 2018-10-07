class Solution {
    public int catMouseGame(int[][] graph) {
        if (graph == null) {
            return 0;
        }
        int[][][] dp = new int[graph.length][graph.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(graph, dp, 1, 2, 0);
    }
    private int helper(int[][] graph, int[][][] dp, int mouse, int cat, int state) {
        if (dp[mouse][cat][state] != -1) {
            return dp[mouse][cat][state];
        }
        dp[mouse][cat][state] = 0;
        int result;
        if (state == 0) {
            // mouse
            for (int i : graph[mouse]) {
                if (i == 0) {
                    dp[mouse][cat][state] = 1;
                    return 1;
                }
            }
            result = 2;
            for (int i : graph[mouse]) {
                if (i == cat) {
                    continue;
                }
                int res = helper(graph, dp, i, cat, state ^ 1);
                if (res == 1) {
                    dp[mouse][cat][state] = 1;
                    return 1;
                } else if (res == 0) {
                    result = 0;
                }
            }
        } else {
            for (int i : graph[cat]) {
                if (mouse == i) {
                    dp[mouse][cat][state] = 2;
                    return 2;
                }
            }
            result = 1;
            for (int i : graph[cat]) {
                if (i == 0) {
                    continue;
                }
                int res = helper(graph, dp, mouse, i, state ^ 1);
                if (res == 2) {
                    dp[mouse][cat][state] = 2;
                    return 2;
                } else if (res == 0) {
                    result = 0;
                }
            }
        }
        dp[mouse][cat][state] = result;
        return dp[mouse][cat][state];
    }
}