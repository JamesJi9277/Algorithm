class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
            } else if (nums[left] == val && nums[right] != val) {
                nums[left++] = nums[right]; 
                nums[right--] = val;
            } else if (nums[left] == val && nums[right] == val) {
                right--;
            }
        }
        return left;
    }
}

