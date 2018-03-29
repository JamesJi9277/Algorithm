class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int res = left * left + right * right;
            if (res > c) {
                right--;
            } else if (res < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}