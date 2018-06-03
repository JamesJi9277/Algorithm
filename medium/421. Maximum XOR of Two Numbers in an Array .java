class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }
}