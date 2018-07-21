class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int res = Integer.MAX_VALUE;
        while (left < nums.length) {
            int sum = 0;
            int right = left;
            while (right < nums.length) {
                sum += nums[right++];
                if (sum >= s) {
                    res = Math.min(res, right - left);
                    break;
                }
            }
            left++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}