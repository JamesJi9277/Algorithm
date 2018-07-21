// time On2
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// On
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = left;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int[] sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            if(sum[i + 1] >= s) {
                int j = doBinarySearch(0, i, sum[i + 1] - s + 1, sum);
                if(j != -1) {
                    minLen = Math.min(minLen, i - j + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE? 0: minLen;
    }
    private int doBinarySearch(int left, int right, int target, int[] sum) {
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] >= target) {
                right = mid;
            }
            else if(sum[mid] < target) {
                left = mid;
            }
        }
        if(sum[right] < target) {
            return right;
        }
        else if(sum[left] < target) {
            return left;
        }
        else {
            return -1;
        }
    }
}
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// 先求sum数组，然后通过binary search找之前最近的index
