class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // find continious
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}