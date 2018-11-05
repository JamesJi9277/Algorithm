class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int reach = 0;
        int maxReach = 0;
        int count = 0;
        for (int i = 0; i <= maxReach && i < nums.length; i++) {
            if (i > reach) {
                count++;
                reach = maxReach;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1 ? count : 0;
    }
}