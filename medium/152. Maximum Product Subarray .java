class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxLocal;
            maxLocal = Math.max(Math.max(nums[i], max * nums[i]), nums[i] * minLocal);
            minLocal = Math.min(Math.min(nums[i], max * nums[i]), nums[i] * minLocal);
            global = Math.max(maxLocal, global);
        }
        return global;
    }
}