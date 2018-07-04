class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            // 还没有union之前这两个不应该有相同的root
            if (root1 == root2) {
                return false;
            }
            roots[root1] = root2;
        }
        return edges.length == n - 1;
    }
    private int findRoot(int[] roots, int index) {
        while (roots[index] != index) {
            index = roots[index];
        }
        return index;
    }
}