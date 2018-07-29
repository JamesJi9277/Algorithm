class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (j > i && k == 0) {
                    if (sum == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (j > i && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}