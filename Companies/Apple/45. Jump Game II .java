class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int reach = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                reach = maxReach;
                count++;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return count;
    }
}