class Solution {
    public int numberOfPatterns(int m, int n) {
        if (m > n) {
            return 0;
        }
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = skip[3][7] = skip[7][3] = 5;
        boolean[] visited = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(skip, visited, i - 1, 1) * 4;
            res += dfs(skip, visited, i - 1, 2) * 4;
            res += dfs(skip, visited, i - 1, 5);
        }
        return res;
    }
    private int dfs(int[][] skip, boolean[] visited, int remain, int cur) {
        if (remain == 0) {
            return 1;
        }
        visited[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                res += dfs(skip, visited, remain - 1, i);
            }
        }
        visited[cur] = false;
        return res;
    }
}

class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = 2;
        skip[3][1] = 2;
        skip[7][9] = 8;
        skip[9][7] = 8;
        skip[1][7] = 4;
        skip[7][1] = 4;
        skip[3][9] = 6;
        skip[9][3] = 6;
        skip[1][9] = 5;
        skip[9][1] = 5;
        skip[3][7] = 5;
        skip[7][3] = 5;
        skip[2][8] = 5;
        skip[8][2] = 5;
        skip[4][6] = 5;
        skip[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(skip, visited, i - 1, 1) * 4;
            res += dfs(skip, visited, i - 1, 2) * 4;
            res += dfs(skip, visited, i - 1, 5);
        }
        return res;
    }
    private int dfs(int[][] skip, boolean[] visited, int remain, int start) {
        if (remain == 0) {
            return 1;
        }
        visited[start] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[start][i] == 0 || visited[skip[start][i]])) {
                res += dfs(skip, visited, remain - 1, i);
            }
        }
        visited[start] = false;
        return res;
    }
}