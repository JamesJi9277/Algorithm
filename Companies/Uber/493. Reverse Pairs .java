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
            int index1 = binarySearch(sorted, 2l * i + 1);
            int index2 = binarySearch(sorted, i);
            res += getSum(bit, index1);
            update(bit, index2, 1);
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
    private int binarySearch(int[] nums, long target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}


class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = helper(nums, start, mid);
        int right = helper(nums, mid + 1, end);
        int[] merge = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int pointer = j;
        int count = 0;
        int k = 0;
        while (i <= mid) {
            while (pointer <= end && (long)nums[i] > (long)2 * nums[pointer]) {
                pointer++;
            }
            count += pointer - (mid + 1);
            while (j <= end && nums[i] >= nums[j]) {
                merge[k++] = nums[j++];
            }
            merge[k++] = nums[i++];
        }
        while (j <= end) {
            merge[k++] = nums[j++];
        }
        System.arraycopy(merge, 0, nums, start, merge.length);
        return left + right + count;
    }
}


class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = helper(nums, start, mid);
        int right = helper(nums, mid + 1, end);
        Arrays.sort(nums, start, mid + 1);
        Arrays.sort(nums, mid + 1, end + 1);
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if ((long)nums[i] > (long)2 * nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        return left + right + count;
    }
}