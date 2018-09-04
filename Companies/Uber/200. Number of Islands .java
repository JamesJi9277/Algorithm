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
    private void helper(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '0') {
            return;
        }
        board[row][col] = '0';
        helper(board, row + 1, col);
        helper(board, row - 1, col);
        helper(board, row, col + 1);
        helper(board, row, col - 1);
    }
}


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