class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (left < right && !isVowels(sb.charAt(left))) {
                left++;
            }
            while (left < right && !isVowels(sb.charAt(right))) {
                right--;
            }
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb.toString();
    }
    private boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}