class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}