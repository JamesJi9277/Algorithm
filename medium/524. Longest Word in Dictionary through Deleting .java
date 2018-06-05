class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String s1 : d) {
            if (isSub(s, s1) && compare(s1, res) < 0) {
                res = s1;
            }
        }
        return res;
    }
    private int compare(String s1, String s2) {
        // 保证字典序最小并且又是最长的结果
        return s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length();
    }
    private boolean isSub(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        for (index1 = 0; index1 < s1.length(); index1++) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index2++;
            }
            if (index2 == s2.length()) {
                return true;
            }
        }
        return false;
    }
}