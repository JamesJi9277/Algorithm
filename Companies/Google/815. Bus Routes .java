class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<Integer>());
                map.get(routes[i][j]).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        Set<Integer> visitedRoute = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int route : map.get(temp)) {
                    if (visitedRoute.contains(route)) {
                        continue;
                    }
                    visitedRoute.add(route);
                    for (int stop : routes[route]) {
                        if (stop == T) {
                            return step;
                        }
                        queue.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
}