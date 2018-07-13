class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        if (!canBreak(s, wordDict)) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(s, wordDict, res, sb, 0);
        return res;
    }
    private void helper(String s, List<String> wordDict, List<String> res, StringBuffer sb, int index) {
        if (index == s.length()) {
            res.add(new String(sb).trim());
            return;
        }
        // 这里的顺序是说从0作为起点然后一个个往后面找
        // 主要存在开始满足条件的我就继续dfs下去
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (wordDict.contains(temp)) {
                sb.append(temp);
                sb.append(" ");
                helper(s, wordDict, res, sb, i + 1);
                sb.delete(sb.length() - temp.length() - 1, sb.length());
            }
        }
    }
    private boolean canBreak(String s, List<String> dict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (res[j] && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}


class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return res;
        }
        if (!canBreak(s, wordDict)) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(s, wordDict, res, sb, 0);
        return res;
    }
    private void helper(String s, List<String> wordDict, List<String> res, StringBuffer sb, int index) {
        if (index == s.length()) {
            res.add(new String(sb).trim());
        }
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (wordDict.contains(temp)) {
                sb.append(temp);
                sb.append(" ");
                helper(s, wordDict, res, sb, i + 1);
                sb.delete(sb.length() - temp.length() - 1, sb.length());
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