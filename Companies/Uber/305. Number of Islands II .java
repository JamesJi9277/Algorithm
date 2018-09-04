class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null) {
            return res;
        }
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        for (int[] pos : positions) {
            count++;
            int root1 = pos[0] * n + pos[1];
            roots[root1] = root1;
            for (int[] dir : directions) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && roots[x * n + y] != -1) {
                    int root2 = findRoot(roots, x * n + y);
                    if (root1 != root2) {
                        roots[root2] = root1;
                        count--;
                    }
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