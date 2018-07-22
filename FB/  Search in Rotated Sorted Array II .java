class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            while (start + 1 < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while (start + 1 < end && nums[end] == nums[end - 1]) {
                end--;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[end] > nums[mid]) {
                if (nums[end] >= target && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}