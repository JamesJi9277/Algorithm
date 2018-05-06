class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int asc = 1;
        int desc = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                asc = desc + 1;
            } else if (nums[i - 1] > nums[i]) {
                desc = asc + 1;
            }
        }
        return Math.max(asc, desc);
    }
}