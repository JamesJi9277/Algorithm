class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if (root1 == root2) {
                return false;
            } else {
                roots[root1] = root2;
            }
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