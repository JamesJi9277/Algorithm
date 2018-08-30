class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        // scan left to right to make sure right higher het more candies
        for (int i = 1; i < res.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        // scan right to left to make sure left higher get more candies
        for (int i = res.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : res) {
            sum += i;
        }
        return sum;
    }
}