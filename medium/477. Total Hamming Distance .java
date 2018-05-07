class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += count(nums[i], nums[j]);
            }
        }
        return res;
    }
    private int count(int i, int j) {
        int k = i ^ j;
        int res = 0;
        for (int m = 0; m < 32; m++) {
            if (((k >> m) & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}


class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += (nums[j] >> i) & 1;
            }
            res += temp * (nums.length - temp);
        }
        return res;
    }
}