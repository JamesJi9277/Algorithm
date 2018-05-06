class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[1];
        helper(nums, S, 0, res, 0);
        return res[0];
    }
    private void helper(int[] nums, int target, int sum, int[] res, int index) {
        if (sum == target && index == nums.length) {
            res[0]++;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        helper(nums, target, sum + nums[index], res, index + 1);
        helper(nums, target, sum - nums[index], res, index + 1);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int[] changed = new int[nums.length];
        int[] res = new int[1];
        helper(nums, sum, changed, res, S, 0);
        return res[0];
    }
    private void helper(int[] nums, int sum, int[] changed, int[] res, int target, int index) {
        if (sum == target) {
            res[0]++;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (changed[i] == 1) {
                continue;
            }
            changed[i] = 1;
            sum -= 2 * nums[i];
            helper(nums, sum, changed, res, target, index + 1);
            sum += 2 * nums[i];
            changed[i] = 0;
        }
    }
}