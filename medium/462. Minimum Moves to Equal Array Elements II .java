class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(nums);
        int medium = nums[nums.length / 2];
        for (int i : nums) {
            sum += Math.abs(i - medium);
        }
        return sum;
    }
}