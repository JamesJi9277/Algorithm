class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i - 1] > nums[i]) {
                swap(nums, i - 1, i);
            } else if (i != 0 && i % 2 == 0 && nums[i - 1] < nums[i]) {
                swap(nums, i - 1, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}