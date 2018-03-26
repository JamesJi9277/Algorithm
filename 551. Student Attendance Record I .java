class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
            }
            if (i > 1 && c == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                countL = 3;
            }
        }
        return !((countA > 1) || (countL == 3));
    }
}