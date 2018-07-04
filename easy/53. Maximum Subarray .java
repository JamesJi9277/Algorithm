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

// dp的话方成表示为到i未直接为的最大的subarray sum，并不是全局最优解，因为这里限制是截止到i的index
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]); // local max to i
            res = Math.max(res, temp); // global max
        }
        return res;
    }
}