class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] res = new int[nums.length];
        int max = 0;
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
        }
        for (int i : res) {
            max = Math.max(max, i);
        }
        return max;
    }
}


10, 9, 2, 5, 3, 7, 101
2, 3, 7, 101  
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] res = new int[nums.length];
        int len = 0;
        res[0] = nums[0];
        len++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < res[0]) {
                res[0] = nums[i];
            } else if (res[len - 1] < nums[i]) {
                res[len++] = nums[i]; 
            } else {
                int index = binarySearch(res, 0, len - 1, nums[i]);
                res[index] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] res, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res[mid] == target) {
                return mid;
            } else if (res[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (res[start] == target) {
            return start;
        } else {
            return end;
        }
    }
}