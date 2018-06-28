// 找到从0开始最长的palindrome
// 然后reverse剩下的部分然后append到前面
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(0, i + 1))) {
                break;
            }
        }
        if (i == s.length() - 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer(s.substring(i + 1));
        return sb.reverse().toString() + s;
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (int i = 0; start + i < end - i; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}