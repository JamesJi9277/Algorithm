https://leetcode.com/problems/distinct-subsequences/discuss/37320/Java-.
https://leetcode.com/problems/distinct-subsequences/discuss/137814/Java-DP-solution-with-an-easier-explanation


class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int[][] res = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[s.length()][t.length()];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<String> substrings = helper(s);
        int count = 0;
        for (String s1 : substrings) {
            if (s1.equals(t)) {
                count++;
            }
        }
        return count;
    }
    private List<String> helper(String s) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        helper1(s, sb, res, 0);
        return res;
    }
    private void helper1(String s, StringBuffer sb, List<String> res, int index) {
        for (int i = index; i < s.length(); i++) {
            res.add(new String(sb));
            sb.append(s.charAt(i));
            helper1(s, sb, res, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}