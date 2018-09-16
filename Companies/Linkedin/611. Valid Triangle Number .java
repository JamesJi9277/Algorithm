class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    res += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}