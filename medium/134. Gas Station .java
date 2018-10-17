class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return 0;
        }
        int index = 0;
        int total = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            if (tank < 0) {
                // 记得tank也需要置零处理
                tank = 0;
                index = i + 1;
            }
            total += diff;
        }
        return total >= 0 ? index : -1;
    }
}