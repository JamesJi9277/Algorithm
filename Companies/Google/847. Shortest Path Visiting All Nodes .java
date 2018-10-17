
class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return 0;
        }
        int n = graph.length;
        int target = (1 << n) - 1;
        int count = 0;
        boolean[][] visited = new boolean[n][target];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] state = new int[]{i, 1 << i};
            visited[state[0]][state[1]] = true;
            queue.offer(state);
        }
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int neighbor : graph[temp[0]]) {
                    int key = temp[1] | (1 << neighbor);
                    if (key == target) {
                        return count;
                    }
                    if (visited[neighbor][key]) {
                        continue;
                    }
                    visited[neighbor][key] = true;
                    queue.offer(new int[]{neighbor, key});
                }
            }
        }
        return -1;
    }
}