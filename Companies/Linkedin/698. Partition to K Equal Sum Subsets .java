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
        return helper(nums, visited, k, sum / k, 0, 0);
    }
    private boolean helper(int[] nums, boolean[] visited, int count, int target, int sum, int index) {
        if (count == 0) {
            return true;
        }
        if (sum == target) {
            return helper(nums, visited, count - 1, target, 0, 0);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sum += nums[i];
            if (helper(nums, visited, count, target, sum, i + 1)) {
                return true;
            }
            sum -= nums[i];
            visited[i] = false;
        }
        return false;
    }
}