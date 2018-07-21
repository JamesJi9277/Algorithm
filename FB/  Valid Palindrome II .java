class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 == c2) {
                left++;
                right--;
            } else if (c1 != c2) {
                return valid(s, left + 1, right) || valid (s, left, right - 1);
            }
        }
        return true;
    }
    private boolean valid(String s, int left, int right) {
        if (left > right) {
            return false;
        }
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}