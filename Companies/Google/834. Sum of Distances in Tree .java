class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 0) {
            return new int[1];
        }
        List<int[]>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], 0, 0});
            graph[edge[1]].add(new int[]{edge[0], 0, 0});
        }
        int[] res = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            res[i] = helper(graph, i, visited)[0];
        }
        return res;
    }
    private int[] helper(List<int[]>[] graph, int i, boolean[] visited) {
        visited[i] = true;
        int sum = 0;
        int count = 1;
        for (int[] neighbor : graph[i]) {
            if (!visited[neighbor[0]]) {
                if (neighbor[1] == 0 && neighbor[2] == 0) {
                    int[] temp = helper(graph, neighbor[0], visited);
                    neighbor[1] = temp[0];
                    neighbor[2] = temp[1];
                }
                sum += (neighbor[1] + neighbor[2]);
                count += neighbor[2];
            }
        }
        visited[i] = false;
        return new int[]{sum, count};
    }
}