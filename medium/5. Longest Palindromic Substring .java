class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = helper(s, i, i + 1);
            if (temp.length() > res.length()) {
                res = temp;
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