class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean allUpper = false;
        char c1 = word.charAt(word.length() - 1);
        if (c1 >= 'A' && c1 <= 'Z') {
            allUpper = true;
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (allUpper) {
                if (isLower(c)) {
                    return false;
                }
            } else {
                if (i != 0 && !isLower(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isLower(char c) {
        return (c >= 'a' && c <= 'z');
    }
}