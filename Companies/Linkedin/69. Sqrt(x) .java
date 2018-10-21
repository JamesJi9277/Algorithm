class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
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


class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == (long)x) {
                return (int)mid;
            } else if (mid * mid > (long)x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (start * start <= (long)x) {
            return (int)start;
        } else {
            return (int)end;
        }
    }
}