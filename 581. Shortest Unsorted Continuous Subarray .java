class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] compare = helper(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length && nums[left] == compare[left]) {
            left++;
        }
        while (left < right && nums[right] == compare[right]) {
            right--;
        }
        return right - left + 1;
    }
    private int[] helper(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(result);
        return result;
    }
}