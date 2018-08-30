class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    private int findKth(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        if (left + 1 == k) {
            return nums[left];
        } else if (left + 1 < k) {
            return findKth(nums, left + 1, end, k);
        } else {
            return findKth(nums, start, left - 1, k);
        }
    }
}