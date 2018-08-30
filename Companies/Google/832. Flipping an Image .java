class Solution {
    public int[][] flipAndInvertImage(int[][] nums) {
        int[][] res = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[i][j] = nums[i][nums[0].length - j - 1];
                res[i][j] = (res[i][j] == 1 ? 0 : 1);
            }
        }
        return res;
    }
}
