class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int length = nums.length;
        return length * (length + 1) / 2 - sum;
    }
}