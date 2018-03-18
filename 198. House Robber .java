class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length + 1];
        sum[0] = (long)0;
        sum[1] = (long)nums[0];
        for (int i = 2; i <= nums.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i - 1]);
        }
        return (int)sum[nums.length];
    }
}