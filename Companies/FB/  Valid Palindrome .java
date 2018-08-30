class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        s = s.toUpperCase();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (isValid(c1) && isValid(c2) && c1 == c2) {
                left++;
                right--;
            } else if (!isValid(c1)) {
                left++;
            } else if (!isValid(c2)) {
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean isValid(Character c) {
        if (Character.isDigit(c)) {
            return true;
        } else {
            return c >= 'A' && c <= 'Z';
        }
    }
}