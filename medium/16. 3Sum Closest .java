class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (min > Math.abs(sum - target)) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}