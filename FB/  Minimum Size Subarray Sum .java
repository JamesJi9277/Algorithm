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
// 好题，首先需要考虑到这个sum是不是存在，如果不存在就直接返回0
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = left;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}