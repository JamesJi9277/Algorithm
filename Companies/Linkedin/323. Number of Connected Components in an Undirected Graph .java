class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        int count = 0;
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if (root1 != root2) {
                roots[root1] = root2;
            }
        }
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == i) {
                count++;
            }
        }
        return count;
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}