class Solution {
    public int singleNumber(int[] nums) {
        // a ^ a = 0
        // a ^ 0 = a
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}