public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = s.length() - 1;
        int right = s.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
            while (left >= 0 && valid(s.charAt(left))) {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1));
            sb.append(" ");
            right = left;
            left--;
        }
        return sb.toString().trim();
    }
    private boolean valid(char c) {
        return !(c == ' ');
    }
}