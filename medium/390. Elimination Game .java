class Solution {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * half(n / 2);
    }
    private int half(int n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return 2 * lastRemaining(n / 2) - 1;
        }
        return 2 * lastRemaining(n / 2);
    }
}

class Solution {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return helper(1, n, 1, true);
    }
    // start is the current first number
    // num is count of remaining numbers
    // diff is the interval between two next-to-each-other numbers
    // isFromLeft is from left or from right
    private int helper(int start, int num, int diff, boolean toLeft) {
        if (num == 1) {
            return start;
        } else {
            int newStart = (toLeft || num % 2 == 1) ? (start + diff) : start;
            return helper(newStart, num / 2, diff * 2, !toLeft);
        }
    }
}