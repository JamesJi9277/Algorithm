class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] memo = new int[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1, memo);
    }
    private int helper(int[] nums, int start, int end, int[][] memo) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int val = helper(nums, start, i - 1, memo) + helper(nums, i + 1, end, memo)
                + getValue(nums, start - 1) * nums[i] * getValue(nums, end + 1);
            max = Math.max(max, val);
        }
        memo[start][end] = max;
        return max;
    }
    private int getValue(int[] nums, int index) {
        if (index == -1 || index == nums.length) {
            return 1;
        } else {
            return nums[index];
        }
    }
}