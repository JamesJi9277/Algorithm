class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return res;
        }
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
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (wordDict.contains(temp)) {
                int length = temp.length();
                length++;
                sb.append(" ");
                sb.append(temp);
                helper(res, s, wordDict, i + 1, sb);
                sb.delete(sb.length() - length, sb.length());
            }
        }
    }
    private boolean canBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}