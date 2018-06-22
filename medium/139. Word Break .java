// 因为这里涉及到substring，所以在建立数组的时候要往后多一位
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        if (s == null || s.length() == 0) {
            return true;
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


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] res = new boolean[s.length() + 1];
        int maxLength = helper(wordDict);
        res[0] = true;
        for (int i = 1; i < res.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > maxLength) {
                    break;
                }
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    private int helper(List<String> list) {
        int max = 0;
        for (String s : list) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}