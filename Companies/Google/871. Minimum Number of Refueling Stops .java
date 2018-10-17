class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] s) {
        int cur = startFuel;
        int count = 0;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (true) {
            if (cur >= target) {
                return count;
            }
            while (index < s.length && cur >= s[index][0]) {
                pq.offer(s[index++][1]);
            }
            if (pq.isEmpty()) {
                break;
            }
            count++;
            cur += pq.poll();
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