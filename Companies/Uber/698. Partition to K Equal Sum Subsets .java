class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (k == 0 || sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, k, sum / k, 0);
    }
    private boolean helper(int[] nums, boolean[] visited, int start, int k, int targetSum, int tempSum) {
        if (k == 0) {
            return true;
        }
        if (tempSum == targetSum) {
            return helper(nums, visited, 0, k - 1, targetSum, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, visited, i + 1, k, targetSum, tempSum + nums[i])) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}