class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = 2; skip[3][1] = 2;
        skip[4][6] = 5; skip[6][4] = 5;
        skip[7][9] = 8; skip[9][7] = 8;
        skip[1][7] = 4; skip[7][1] = 4;
        skip[2][8] = 5; skip[8][2] = 5;
        skip[3][9] = 6; skip[9][3] = 6;
        skip[1][9] = 5; skip[9][1] = 5;
        skip[3][7] = 5; skip[7][3] = 5;
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += helper(1, i - 1, new boolean[10], skip) * 4;
            res += helper(2, i - 1, new boolean[10], skip) * 4;
            res += helper(5, i - 1, new boolean[10], skip);
        }
        return res;
    }
    private int helper(int start, int step, boolean[] visited, int[][] skip) {
        if (step == 0) {
            return 1;
        }
        visited[start] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[start][i] == 0 || visited[skip[start][i]])) {
                res += helper(i, step - 1, visited, skip);
            }
        }
        visited[start] = false;
        return res;
    }
}