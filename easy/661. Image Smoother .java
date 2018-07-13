class Solution {
    public int[][] imageSmoother(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int[][] res = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int total = 0;
                int sum = 0;
                for (int m = Math.max(0, i - 1); m <= Math.min(nums.length - 1, i + 1); m++) {
                    for (int n = Math.max(0, j - 1); n <= Math.min(j + 1, nums[0].length - 1); n++) {
                        sum += nums[m][n];
                        total++;
                    }
                }
                res[i][j] = sum / total;
            }
        }
        return res;
    }
}