class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }
}