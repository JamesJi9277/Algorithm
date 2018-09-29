class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            map.putIfAbsent(f[0], new HashMap<Integer, Integer>());
            map.get(f[0]).put(f[1], f[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int step = 0;
        pq.offer(new int[]{src, 0, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int city = temp[0];
            int dist = temp[1];
            if (city == dst) {
                return dist;
            }
            if (temp[2] <= k) {
                Map<Integer, Integer> neighbors = map.getOrDefault(city, new HashMap<>());
                for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                    pq.offer(new int[]{entry.getKey(), entry.getValue() + dist, temp[2] + 1});
                }
            }
        }
        return -1;
    }
}