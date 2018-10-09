class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) {
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
        return helper(nums, visited, 0, 0, k, sum / k);
    }
    private boolean helper(int[] nums, boolean[] visited, int index, int sum, int k, int target) {
        if (sum > target) {
            return false;
        }
        if ( k == 0) {
            return true;
        }
        if (sum == target) {
            return helper(nums, visited, 0, 0, k - 1, target);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sum += nums[i];
            if (helper(nums, visited, i + 1, sum, k, target)) {
                return true;
            }
            sum -= nums[i];
            visited[i] = false;
        }
        return false;
    }
}