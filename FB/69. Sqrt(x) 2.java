class Solution {
    public int mySqrt(int x) {
        // this is so good
        // need to consider Integer overflow problem
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == (long)x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end == (long)x) {
            return (int)end;
        } else {
            return (int)start;
        }
    }
}