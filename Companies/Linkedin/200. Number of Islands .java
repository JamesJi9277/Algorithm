class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                            uf.connect(i, j, x, y);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
    class UnionFind {
        int count = 0;
        int[] roots;
        int m;
        int n;
        public UnionFind(char[][] grid) {
            this.m = grid.length;
            this.n = grid[0].length;
            roots = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        roots[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }
        public void connect(int i, int j, int x, int y) {
            int root1 = findRoot(roots, i * n + j);
            int root2 = findRoot(roots, x * n + y);
            if (root1 != root2) {
                roots[root1] = root2;
                count--;
            }
        }
        private int findRoot(int[] roots, int index) {
            while (index != roots[index]) {
                roots[index] = roots[roots[index]];
                index = roots[index];
            }
            return index;
        }
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }
    private void helper(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        helper(grid, x + 1, y);
        helper(grid, x - 1, y);
        helper(grid, x, y + 1);
        helper(grid, x, y - 1);
    }
}