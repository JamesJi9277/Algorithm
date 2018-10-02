class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null) {
            return null;
        }
        int[] can1 = new int[]{-1, -1};
        int[] can2 = new int[]{-1, -1};
        int[] roots = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (roots[edge[1]] == 0) {
                roots[edge[1]] = edge[0];
            } else {
                can2 = new int[]{edge[0], edge[1]};
                can1 = new int[]{roots[edge[1]], edge[1]};
                edge[1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int child = edge[1];
            int father = edge[0];
            if (findRoot(roots, father) == child) {
                if (can1[0] == -1) {
                    return edge;
                } else {
                    return can1;
                }
            }
            roots[child] = father;
        }
        return can2;
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
            roots[index] = roots[roots[index]];
        }
        return index;
    }
}