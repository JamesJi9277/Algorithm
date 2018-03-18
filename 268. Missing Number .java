class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return n * (n + 1) / 2 - sum;
    }
}