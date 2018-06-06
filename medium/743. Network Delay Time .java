class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new ArrayList<int[]>());
            }
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        int[] path = new int[N];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[K - 1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> (i1[1] - i2[1]));
        pq.offer(new int[]{K, 0});
        HashSet<Integer> visited = new HashSet<Integer>();
        while (pq.size() > 0) {
            while (pq.size() > 0 && visited.contains(pq.peek()[0])) {
                pq.poll();
            }
            if (pq.size() <= 0) {
                break;
            } 
            int[] s = pq.poll();
            visited.add(s[0]);
            if (!map.containsKey(s[0])) {
                continue;
            }
            for (int[] neighbor : map.get(s[0])) {
                if (s[1] + neighbor[1] < path[neighbor[0] - 1]) {
                    path[neighbor[0] - 1] = s[1] + neighbor[1];
                    pq.add(new int[]{neighbor[0], path[neighbor[0] - 1]});
                }
            }
        }
        if (visited.size() != N) {
            return -1;
        }
        int max = 0;
        for (int n : path) {
            max = Math.max(max, n);
        }
        return max;
    }
}