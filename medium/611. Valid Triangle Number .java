class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] && Math.abs(nums[i] - nums[j]) < nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

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