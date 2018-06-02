class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return canPartition(nums, sum, 0, 0);
    }
    private boolean canPartition(int[] nums, int sum1, int sum2, int index) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (sum1 - nums[i] < sum2 + nums[i]) {
                break;
            }
            
            if (sum1 - nums[i] == sum2 + nums[i] || canPartition(nums, sum1 - nums[i], sum2 + nums[i], i + 1)) {
                return true;
            }
        }
        return false;
    }
}