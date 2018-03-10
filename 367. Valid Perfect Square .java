class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 1;
        long end = num;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == (long)num) {
                return true;
            } else if (mid * mid < (long)num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == (long)num) {
            return true;
        } else if (end * end == (long)num) {
            return true;
        } else {
            return false;
        }
    }
}