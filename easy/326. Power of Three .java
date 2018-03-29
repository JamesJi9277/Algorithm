// while loop
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

// memory exceeds
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        boolean[] array = new boolean[n + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
        for (int i = 1; i < array.length; i *= 3) {
            array[i] = true;
        }
        return array[n];
    }
}

// 这个方法的要领需要好好掌握
class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}