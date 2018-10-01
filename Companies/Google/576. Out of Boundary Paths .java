class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int mod = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] memo = new long[m][n][N + 1];
        for (long[][] a : memo) {
            for (long[] b : a) {
                Arrays.fill(b, -1);
            }
        } 
        return (int)(helper(m, n, N, i, j, memo) % mod);
    }
    private long helper(int m, int n, int N, int i, int j, long[][][] memo) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[i][j][N] != -1) {
            return memo[i][j][N];
        }
        memo[i][j][N] = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            memo[i][j][N] = (memo[i][j][N] + helper(m, n, N - 1, x, y, memo) % mod) % mod;
        }
        return memo[i][j][N];
    }
}
class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static final int mod = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] temp = queue.poll();
                int step = temp[2];
                if (step > N) {
                    continue;
                }
                int x = temp[0];
                int y = temp[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    for (int[] dir : directions) {
                        queue.offer(new int[]{x + dir[0], y + dir[1], step + 1});
                    }
                } else {
                    count++;
                }
            }
        }
        return count % mod;
    }
}