class Solution {
    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
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
                if (x < 0 || x >= m || y < 0 || y >= n || roots[x * n + y] == -1) {
                    continue;
                }
                int newRoot = findRoot(roots, x * n + y);
                if (roots[newRoot] != root) {
                    roots[newRoot] = root;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int findRoot(int[] nums, int index) {
        while (index != nums[index]) {
            nums[index] = nums[nums[index]];
            index = nums[index];
        }
        return index;
    }
}