class Solution {
    public boolean canJump(int[] nums) {
        // greedy
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reach = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
        }
        return reach >= nums.length - 1;
    }
}
class Solution {
    // DP
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (reach[j] && nums[j] + j >= i) {
                    reach[i] = true;
                    break;
                }
            }
        }
        return reach[reach.length - 1];
    }
}