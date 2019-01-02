class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isPos = (x > 0);
        long res = 0;
        x = Math.abs(x);
        while (x != 0) {
            int temp = x % 10;
            if (res == 0 && temp == 0) {
                x /= 10;
                continue;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        res = isPos ? res : -res;
        if (res >= Integer.MAX_VALUE) {
            return 0;
        } else if (res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}