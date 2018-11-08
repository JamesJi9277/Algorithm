class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == -1 && !helper(graph, i, colors, 0)) {
                return false;
            }
        }
        return true;
    }
    private boolean helper(int[][] graph, int index, int[] colors, int color) {
        if (colors[index] != -1) {
            return colors[index] == color;
        }
        colors[index] = color;
        for (int neighbor : graph[index]) {
            if (!helper(graph, neighbor, colors, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}