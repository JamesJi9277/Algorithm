class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        if (m == 1) {
            return (int)sum;
        }
        long left = max;
        long right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (valid(mid, nums, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }
    private boolean valid(long target, int[] nums, int m) {
        // already have one part
        int count = 1;
        long total = 0;
        for (int i : nums) {
            total += i;
            if (total > target) {
                // start from i again
                total = i;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}