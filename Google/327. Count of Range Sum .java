class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        for (int i = 0; i < nums.length; i++) {
            long temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp <= (long)upper && temp >= (long)lower) {
                    count++;
                }
            }
        }
        return count;
    }
}
// 通过mergesort来找到答案
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return mergeSort(sum, 0, nums.length + 1, lower, upper);
    }
    private int mergeSort(long[] sum, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = mergeSort(sum, start, mid, lower, upper) + mergeSort(sum, mid, end, lower, upper);
        int j = mid;
        int k = mid;
        int t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && sum[k] - sum[i] < lower) k++;
            while (j < end && sum[j] - sum[i] <= upper) j++;
            while (t < end && sum[t] < sum[i]) cache[r++] = sum[t++];
            cache[r] = sum[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sum, start, t - start);
        return count;
    }
}

// divide and conquer
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        int index = 0;
        while (index < nums.length) {
            if (index == 0) {
                sum[index] = nums[index];
            } else {
                sum[index] = sum[index - 1] + nums[index];
            }
            index++;
        }
        return helper(nums, sum, lower, upper, 0, nums.length - 1);
    }
    private int helper(int[] nums, long[] sum, int lower, int upper, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            if (nums[start] >= lower && nums[end] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = (start + end) / 2;
        int total = 0;
        for (int i = start; i <= mid; i++) {
            for (int j = mid + 1; j <= end; j++) {
                long temp = sum[j] - sum[i] + nums[i];
                if (temp >= lower && temp <= upper) {
                    total++;
                }
            }
        }
        return total + helper(nums, sum, lower, upper, start, mid) + helper(nums, sum, lower, upper, mid + 1, end);
    }
}