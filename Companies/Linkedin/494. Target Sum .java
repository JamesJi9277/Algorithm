class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        helper(nums, sum, s, 0);
        return count;
    }
    private void helper(int[] nums, int sum, int target, int index) {
        if (sum < target) {
            return;
        }
        if (sum == target) {
            count++;
        }
        for (int i = index; i < nums.length; i++) {
            sum -= 2 * nums[i];
            helper(nums, sum, target, i + 1);
            sum += 2 * nums[i];
        }
    }
}