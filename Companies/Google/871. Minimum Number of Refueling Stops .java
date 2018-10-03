class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cur = startFuel;
        int index = 0;
        int count = 0;
        while (true) {
            if (cur >= target) {
                return count;
            }
            while (index < stations.length && cur >= stations[index][0]) {
                pq.offer(stations[index++][1]);
            }
            if (pq.isEmpty()) {
                break;
            }
            cur += pq.poll();
            count++;
        }
        return -1;
    }
}


class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; i++)
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; t--)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
        for (int t = 0; t <= s.length; t++)
            if (dp[t] >= target) return t;
        return -1;
    }
}