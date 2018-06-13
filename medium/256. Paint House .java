class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int preRed = costs[0][0];
        int preBlue = costs[0][1];
        int preGreen = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curRed = costs[i][0] + Math.min(preBlue, preGreen);
            int curBlue = costs[i][1] + Math.min(preRed, preGreen);
            int curGreen = costs[i][2] + Math.min(preRed, preBlue);
            preRed = curRed;
            preBlue = curBlue;
            preGreen = curGreen;
        }
        return Math.min(preRed, Math.min(preGreen, preBlue));
    }
}