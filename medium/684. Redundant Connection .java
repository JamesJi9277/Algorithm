class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return null;
        }
        int[] roots = new int[2000];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if (root1 == root2) {
                return edge;
            }
            roots[root1] = root2;
        }
        return null;
    }
    private int findRoot(int[] roots, int index) {
        while (roots[index] != index) {
            index = roots[index];
        }
        return index;
    }
}