class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean[] isValid = new boolean[s.length() + 1];
        isValid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isValid[j] && wordDict.contains(s.substring(j, i))) {
                    isValid[i] = true;
                    break;
                }
            }
        }
        return isValid[s.length()];
    }
}