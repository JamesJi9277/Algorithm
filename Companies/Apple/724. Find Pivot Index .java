class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (left + 1 < right) {
            leftSum += nums[left];
            rightSum += nums[right];
            if (left + 1 == right) {
                if (leftSum == rightSum) {
                    return left + 1;
                }
            } else if (left + 1 < right) {
                if (leftSum < rightSum) {
                    left++;
                } else if (leftSum > rightSum) {
                    right--;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * preSum) {
                return i;
            } else {
                preSum += nums[i];
            }
        }
        return -1;
    }
}