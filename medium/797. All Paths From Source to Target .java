class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0, new ArrayList<>(), new ArrayList<List<Integer>>());
    }
    private void List<List<Integer>> dfs(int[][] graph, int s, List<Integer> path, List<List<Integer>> out) {
        path.add(s);
        if (s == graph.length - 1) out.add(new ArrayList<Integer>(path));
        for(int i = 0; i < graph[s].length; i++) 
        dfs(graph, graph[s][i], path, out);
        path.remove(path.size() - 1);
        return out;
    }
}