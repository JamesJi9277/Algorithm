class Solution {
    public int countPalindromicSubsequences(String str) {
  TreeSet[] positions = new TreeSet[26];
  Integer[][] cache = new Integer[str.length()][str.length()];
  for (int i = 0; i < positions.length; i++) {
    positions[i] = new TreeSet<Integer>();
  }
  for (int i = 0; i < str.length(); i++) {
    positions[str.charAt(i) - 'a'].add(i);
  }
  return helper(positions, cache, 0, str.length() - 1);
}

private int helper(TreeSet[] positions, Integer[][] cache, int start, int end) {
  if (start > end) return 0;
  if (cache[start][end] != null) return cache[start][end];
  int ans = 0;
  for (int i = 0; i < positions.length; i++) {
    Integer subStart = positions[i].ceiling(start);
    Integer subEnd = positions[i].floor(end);
    if (subStart == null) continue;    // checked subsequences are less than start
    if (subStart > end) continue;      // checked subsequences are greater than end
    if (subStart == subEnd) {
      ans = ans + 1;
    } else {
      ans = ans + 2;
    }
    ans = ans + helper(positions, cache, subStart + 1, subEnd - 1);
  }
  ans  = ans % 1000000007;
  cache[start][end] = ans;
  return ans;
}

}

class Solution {
    int mod = (int)1e9 + 7;
    public int countPalindromicSubsequences(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    int left = i + 1;
                    int right = j - 1;
                    while (left < s.length() && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    while (right >= 0 && s.charAt(right) != s.charAt(j)) {
                        right--;
                    }
                    if (left > right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (left == right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }
        return dp[0][s.length() - 1];
    }
}