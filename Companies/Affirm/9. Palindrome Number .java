class Solution {
    public boolean isPalindrome(int x) {
        StringBuffer sb = new StringBuffer("" + x);
        if (sb.charAt(0) == '+' || sb.charAt(0) == '-') {
            return false;
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}