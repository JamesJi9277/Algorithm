class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (!canBreak(s, wordDict)) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, s, wordDict, 0, sb);
        return res;
    }
    private void helper(List<String> res, String s, List<String> wordDict, int index, StringBuffer sb) {
        if (index == s.length()) {
            res.add(new String(sb).trim());
            return;
        }
        int len = sb.length();
        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp)) {
                sb.append(temp);
                sb.append(" ");
                helper(res, s, wordDict, i, sb);
                sb.setLength(len);
            }
        }
    }
    private boolean canBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}