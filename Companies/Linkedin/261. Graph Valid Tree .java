class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(edge[0], roots);
            int root2 = findRoot(edge[1], roots);
            if (root1 == root2) {
                return false;
            } else {
                roots[root1] = root2;
            }
        }
        return edges.length == n - 1;
    }
    private int findRoot(int index, int[] roots) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}