class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2000];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int f = edge[0];
            int p = edge[1];
            if (find(parent, f) == find(parent, p)) {
                return edge;
            } else {
                parent[find(parent, f)] = find(parent, p);
            }
        }
        return new int[2];
    }
    private int find(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}