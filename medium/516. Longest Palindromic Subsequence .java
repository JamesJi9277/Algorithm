class Solution {
    public int longestPalindromeSubseq(String s) {
        //在所有的subset里面找palindrome
        //估计会TLE和栈溢出
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<String> list = helper(s);
        int max = 0;
        for (String s1 : list) {
            if (isValid(s1)) {
                max = Math.max(max, s1.length());
            }
        }
        return max;
    }
    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private List<String> helper(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        dfs(s, res, sb, 0);
        return res;
    }
    private void dfs(String s, List<String> res, StringBuffer sb, int index) {
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            res.add(sb.toString());
            dfs(s, res, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}

https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
// self write, bug free
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}