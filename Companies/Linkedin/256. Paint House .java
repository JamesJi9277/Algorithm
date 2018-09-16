class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int preRed = costs[0][0];
        int preGreen = costs[0][1];
        int preBlue = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curRed = costs[i][0] + Math.min(preBlue, preGreen);
            int curGreen = costs[i][1] + Math.min(preRed, preBlue);
            int curBlue = costs[i][2] + Math.min(preRed, preGreen);
            preRed = curRed;
            preGreen = curGreen;
            preBlue = curBlue;
        }
        return Math.min(preRed, Math.min(preGreen, preBlue));
    }
}