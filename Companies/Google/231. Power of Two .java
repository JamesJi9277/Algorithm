class Solution {
    public boolean isPowerOfTwo(int n) {
        // recursive
        // if (n == 0) {
        //     return false;
        // }
        // if (n == 1) {
        //     return true;
        // }
        // if (n % 2 == 0) {
        //     return isPowerOfTwo(n / 2);
        // }
        // return false;
        //
        // if (n == 0) {
        //     return false;
        // }
        // if (n == 1) {
        //     return true;
        // }
        // while (n % 2 == 0) {
        //     n /= 2;
        // }
        // return n == 1;
        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
}


class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }
}