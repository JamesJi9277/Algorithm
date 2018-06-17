class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] < 1) {
                right++;
            } else if (nums[right] - nums[left] == 1) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return max;
    }
}

class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Arrays.sort(nums);
        while (right < nums.length) {
            if (nums[right] - nums[left] < 1) {
                right++;
            } else if (nums[right] - nums[left] == 1) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return max;
    }
}