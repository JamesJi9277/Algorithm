class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int weight = nums[nums.length - 1];
        for (int i = res.length - 2; i >= 0; i--) {
            res[i] *= weight;
            weight *= nums[i];
        }
        return res;
    }
}