// dfs, TLE
class Solution {
    int count;
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 1) {
            return 0;
        }
        count = 0;
        helper(nums, 0, target);
        return count;
    }
    private void helper(int[] nums, int sum, int target) {
        if (sum == target) {
            count++;
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            helper(nums, sum, target);
            sum -= nums[i];
        }
    }
}


// dfs + memo
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        for (int i : nums) {
            count += combinationSum4(nums, target - i);
        }
        map.put(target, count);
        return count;
    }
}