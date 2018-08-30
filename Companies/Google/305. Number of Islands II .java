class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        for (int[] p : positions) {
            int root = p[0] * n + p[1];
            roots[root] = root;
            count++;
            for (int[] dir : directions) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                // 表示all good,旁边没有岛
                if (x < 0 || x >= m || y < 0 || y >= n || roots[x * n + y] == -1) {
                    continue;
                }
                // 表示找到了岛，然后就要更新root同时还要去减少count
                int root2 = findRoot(roots, x * n + y);
                if (roots[root2] != root) {
                    roots[root2] = root;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}


class Solution {
    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        for (int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;
            for (int[] dir : directions) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && roots[x * n + y] != -1) {
                    int newRoot = findRoot(roots, x * n + y);
                    if (newRoot != root) {
                        roots[newRoot] = root;
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    private int findRoot(int[] roots, int index) {
        while (roots[index] != index) {
            index = roots[index];
        }
        return index;
    }
}