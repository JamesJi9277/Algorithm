class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int s) {
        // all non-negative
        if (nums == null || nums.length == 0) {
            return count;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        helper(nums, s, sum, 0);
        return count;
    }
    private void helper(int[] nums, int target, int sum, int index) {
        if (sum < target) {
            return;
        }
        if (sum == target) {
            count++;
        }
        for (int i = index; i < nums.length; i++) {
            sum -= nums[i] * 2;
            helper(nums, target, sum, i + 1);
            sum += nums[i] * 2;
        }
    }
}