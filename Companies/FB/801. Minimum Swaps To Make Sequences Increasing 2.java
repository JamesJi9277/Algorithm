class Solution {
    public int minSwap(int[] a, int[] b) {
        int[][] dp = new int[a.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1] && b[i] > b[i - 1] && a[i] > b[i - 1] && b[i] > a[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else if (a[i] > a[i - 1] && b[i] > b[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[a.length - 1][0], dp[a.length - 1][1]);
    }
}
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119995/Java-neat-and-easy-to-understand-DP-O(n)-solution!
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-Easy-Understood-DP-Solution

class Solution {
    public int minSwap(int[] A, int[] B) {
        int[] swap = new int[A.length];
        int[] keep = new int[A.length];
        swap[0] = 1;
        keep[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1] && A[i] > B[i - 1] && B[i] > A[i - 1]) {
                keep[i] = Math.min(keep[i - 1], swap[i - 1]);
                swap[i] = Math.min(keep[i - 1], swap[i - 1]) + 1;
            } else if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            } else {
                keep[i] = swap[i - 1];
                swap[i] = keep[i - 1] + 1;
            }
        }
        return Math.min(keep[A.length - 1], swap[A.length - 1]);
    }
}