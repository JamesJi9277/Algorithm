class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countBit(i);
        }
        return res;
    }
    private int countBit(int num) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}

class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}

class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}