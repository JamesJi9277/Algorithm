TLE
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        while (left < nums.length) {
            while (right < nums.length) {
                product *= nums[right];
                if (product < k) {
                    count++;
                    right++;
                } else {
                    break;
                }
            }
            left++;
            right = left;
            product = 1;
        }
        return count;
    }
}


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}