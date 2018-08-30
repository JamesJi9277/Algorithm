class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if (root1 == root2) {
                return false;
            }
            roots[root1] = root2;
        }
        // this step is essential
        // can help me determine if suffcient edge is provided
        return edges.length == n - 1;
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}