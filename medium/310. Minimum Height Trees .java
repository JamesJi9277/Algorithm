class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        //首先这一题是无向图，所以用degree来表示
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int[] edge : edges) {
                    if (edge[0] == temp) {
                        degree[edge[1]]--;
                        if (degree[edge[1]] == 1) {
                            queue.offer(edge[1]);
                        }
                        n--; 
                        //相当于是抹去这条边，不会在接下来再进行对比了
                        edge[0]=-1;
                        edge[1]=-1;
                    } else if (edge[1] == temp) {
                        degree[edge[0]]--;
                        if (degree[edge[0]] == 1) {
                            queue.offer(edge[0]);
                        }
                        n--; 
                        edge[0]=-1;
                        edge[1]=-1;
                    }
                }
            }
        }
        return new ArrayList<Integer>(queue);
    }
}