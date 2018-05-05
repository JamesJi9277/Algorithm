class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
            	// 始终会出现在第一位
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
            	// 跳过一个pair
                start = mid + 2;
            }
        }
        return nums[start];
    }
}