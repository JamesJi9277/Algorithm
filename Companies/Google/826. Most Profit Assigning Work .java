class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < profit.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        Collections.sort(list, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < worker.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < list.size(); j++) {
                if (worker[i] >= list.get(j)[0]) {
                    tempMax = Math.max(tempMax, list.get(j)[1]);
                }
            }
            res += tempMax;
        }
        return res;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] dp = new int[100001];
        for (int i = 0; i < difficulty.length; i++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
        }
        int sum = 0;
        for (int i : worker) {
            sum += dp[i];
        }
        return sum;
    }
}