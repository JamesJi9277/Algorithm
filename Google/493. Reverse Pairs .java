// This is because an important reverse pair satisfies nums[i] > 2*nums[j]. 
// Pay attention to the greater sign here. 
// The search function in the BIT solution will return the number of elements 
// greater than or equal to the given target element. If we don't shift 2*nums[j] up by 1, the answer will 
// include elements that are equal to 2 * nums[j], 
// which by definition do NOT count as important reverse pairs.
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] bit = new int[nums.length + 1];
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int res = 0;
        for (int i : nums) {
            res += getSum(bit, binarySearch(sorted, 2L * i + 1));
            update(bit, binarySearch(sorted, i), 1);
        }
        return res;
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index + 1; i < bit.length; i += (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
    private void update(int[] bit, int index, int value) {
        for (int i = index + 1; i > 0; i -= (i & (-i))) {
            bit[i] += value;
        }
    }
    
    private int binarySearch(int[] nums, long val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= val) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        // 返回bit内的index，要加一
        return i;
    }
    private int binarySearch1(int[] nums, long target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else {
            return end;
        }
    }
    
}

http://www.cnblogs.com/grandyang/p/6657956.html
https://leetcode.com/problems/reverse-pairs/discuss/97268/general-principles-behind-problems-similar-to-reverse-pairs