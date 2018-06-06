class Solution {
    public int longestMountain(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, helper(nums, i));
        }
        return max;
    }
    private int helper(int[] nums, int pivot) {
        int left = pivot;
        int right = pivot;
        int leftPrev = pivot - 1;
        int rightAfter = pivot + 1;
        while (leftPrev >= 0 && rightAfter < nums.length && nums[leftPrev] < nums[left] && nums[right] > nums[rightAfter]) {
            left--;
            right++;
            leftPrev = left - 1;
            rightAfter = right + 1;
        }
        return left == right ? 0 : right - leftPrev;
    }
}

class Solution {
    public int longestMountain(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] increase = new int[nums.length];
        int[] decrease = new int[nums.length];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                increase[i] = increase[i - 1] + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] < nums[i]) {
                decrease[i] = decrease[i + 1] + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (increase[i] > 0 && decrease[i] > 0) {
                max = Math.max(max, increase[i] + decrease[i] + 1);
            }
        }
        return max;
    }
}


class Solution {
       public int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }
}