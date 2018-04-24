class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            return 0;
        }
        if (m == n) {
            return m;
        }
        if (m + 1 == n) {
            return helper(m, n);
        }
        int left = rangeBitwiseAnd(m, m + (n - m) / 2);
        int right = rangeBitwiseAnd(m + (n - m) / 2 + 1, n);
        return helper(left, right);
    }
    private int helper(int m, int n) {
        return m & n;
    }
}


class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        return n;
    }
}