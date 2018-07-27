class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}