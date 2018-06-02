class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int res = 0;
        boolean isAddable = false;
        for (int i = 3; i < dp.length; i++) {
            if (nums[i - 2] - nums[i - 3] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                if (isAddable) {
                    res += dp[i];
                } else {
                    res++;
                    isAddable = true;
                }
            } else {
                isAddable = false;
                dp[i] = 0;
            }
        }
        return res;
    }
}