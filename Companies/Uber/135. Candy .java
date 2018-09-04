class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i != 0 && ratings[i - 1] < ratings[i]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i != ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        for (int i : res) {
            sum += i;
        }
        return sum;
    }
}