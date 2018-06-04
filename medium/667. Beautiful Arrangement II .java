class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1;
        int right = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = (k % 2 == 0) ? right-- : left++;
            if (k > 1) {
                k--;
            }
        }
        return res;
    }
}

https://leetcode.com/problems/beautiful-arrangement-ii/discuss/106948/C++-Java-Clean-Code-4-liner