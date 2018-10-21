class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, k, sum / k, 0, 0);
    }
    private boolean helper(int[] nums, boolean[] visited, int count, int k, int target, int sum, int index) {
        if (count == k - 1) {
            return true;
        }
        if (target == sum) {
            return helper(nums, visited, count + 1, k, target, 0, 0);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, visited, count, k, target, sum + nums[i], i + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}