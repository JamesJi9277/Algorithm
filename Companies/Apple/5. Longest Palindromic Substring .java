class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = helper(s, i, i);
            if (s1.length() > res.length()) {
                res = s1;
            }
            if (i > 0) {
                s1 = helper(s, i - 1, i);
                if (s1.length() > res.length()) {
                    res = s1;
                }
            }
        }
        return res;
    }
    private String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}