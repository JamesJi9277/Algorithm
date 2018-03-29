class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) { // normal situation
            return true;
        }
        if (isValid(s, i + 1, j) || isValid(s, i, j - 1)) {
            return true;
        }
        return false;
    }
    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}