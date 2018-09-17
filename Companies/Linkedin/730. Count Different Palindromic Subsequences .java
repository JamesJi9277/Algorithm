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