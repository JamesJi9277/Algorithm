class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.connect(i, j, i - 1, j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.connect(i, j, i, j - 1);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        uf.connect(i, j, i + 1, j);
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                        uf.connect(i, j, i, j + 1);
                    }
                }
            }
        }
        return uf.count;
    }
}
class UnionFind {
    char[][] grid;
    int[] roots;
    int count;
    public UnionFind(char[][] grid) {
        this.grid = grid;
        roots = new int[grid.length * grid[0].length];
        count = 0;
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
    }
    public void connect(int x1, int y1, int x2, int y2) {
        int root1 = findRoot(roots, x1 * grid[0].length + y1);
        int root2 = findRoot(roots, x2 * grid[0].length + y2);
        if (root1 != root2) {
            roots[root1] = root2;
            count--;
        }
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}