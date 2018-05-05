class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[j] && nums[j] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < first) {
                first = i;
            }
            if (i > first && i < second) {
                second = i;
            }
            if (i > second) {
                return true;
            }
        }
        return false;
    }
}