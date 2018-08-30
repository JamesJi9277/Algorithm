class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int preZero = -1;
        int len = 0;
        // [left, i] is all 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = preZero + 1;
                preZero = i;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        return helper(nums, 1);
    }
    private int helper(int[] nums, int k) {
        int max = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}