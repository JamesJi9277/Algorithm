// first bad version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        } else {
            return end;
        }
    }
}

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int end = nums[nums.length - 1] - nums[0];
        int start = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            start = Math.min(start, nums[i + 1] - nums[i]);
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countPairs(nums, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countPairs(nums, start) < k) {
            return end;
        } else {
            return start;
        }
    }
    private int countPairs(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += findFirstDiffGreater(nums, i, nums.length - 1, nums[i] + diff) - i - 1;
        }
        return res;
    }
    private int findFirstDiffGreater(int[] nums, int i, int j, int target) {
        int start = i;
        int end = j;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else {
            return end;
        }
    }
}




class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end == x) {
            return (int)end;
        } else {
            return (int)start;
        }
    }
}