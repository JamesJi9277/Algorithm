class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : flights) {
            map.putIfAbsent(edge[0], new HashMap<>());
            map.get(edge[0]).put(edge[1], edge[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.offer(new int[]{src, 0, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int city = temp[0];
            int dist = temp[1];
            int step = temp[2];
            if (city == dst) {
                return dist;
            }
            if (step <= K) {
                Map<Integer, Integer> neighbor = map.getOrDefault(city, new HashMap<>());
                for (Map.Entry<Integer, Integer> entry : neighbor.entrySet()) {
                    pq.offer(new int[]{entry.getKey(), dist + entry.getValue(), step + 1});
                }
            }
        }
        return -1;
    }
}