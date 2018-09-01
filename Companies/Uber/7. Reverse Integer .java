class Solution {
    public int reverse(int x) {
        // test case : negative, trailing zero, overflow
        if (x == 0) {
            return 0;
        }
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }
        long num = Math.abs(x);
        long res = 0;
        while (num != 0) {
            long temp = num % 10;
            res = res * 10 + temp;
            num /= 10;
        }
        res = isNeg ? -res : res;
        if (res >= Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}