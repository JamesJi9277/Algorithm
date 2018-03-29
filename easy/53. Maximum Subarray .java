class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tempMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempMax = Math.max(nums[i], tempMax + nums[i]);
            globalMax = Math.max(globalMax, tempMax);
        }
        return globalMax;
    }
}