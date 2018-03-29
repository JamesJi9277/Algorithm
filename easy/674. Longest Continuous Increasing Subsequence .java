class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int max = Integer.MIN_VALUE;
        while (left < nums.length) {
            int right = left + 1;
            while (right < nums.length && nums[right] > nums[right - 1]) {
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        return max;
    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}