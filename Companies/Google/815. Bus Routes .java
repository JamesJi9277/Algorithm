class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        if (S == T) {
            return 0;
        }
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<Integer>());
                map.get(routes[i][j]).add(i);
            }
        }
        queue.offer(S);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int bus : map.get(cur)) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for (int stop : routes[bus]) {
                        if (stop == T) {
                            return steps;
                        }
                        queue.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
}