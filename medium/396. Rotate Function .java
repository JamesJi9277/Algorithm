https://leetcode.com/problems/rotate-function/discuss/87853/Java-O(n)-solution-with-explanation

class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int allSum = 0;
        int len = nums.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * nums[i];
            allSum += nums[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * nums[i];
            max = Math.max(F, max);
        }
        return max;   
    }
}