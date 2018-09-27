class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i;
        int j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (j = nums.length - 1; j >= i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums, i + 1, nums.length - 1);
        return;
    }
    private void reverse(int[] nums, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}