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
        int[] visited = new int[nums.length];
        return helper(nums, visited, 0, k, 0, 0, sum / k);
    }
    private boolean helper(int[] nums, int[] visited, int start, int k, int curSum, int curNum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return helper(nums, visited, 0, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (helper(nums, visited, i + 1, k, curSum + nums[i], curNum + 1, target)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}