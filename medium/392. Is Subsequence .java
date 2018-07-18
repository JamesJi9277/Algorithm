class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length()) {
            char c1 = s.charAt(index1);
            char c2 = t.charAt(index2);
            if (c1 == c2) {
                index1++;
                if (index1 == s.length()) {
                    return true;
                }
            }
            index2++;
        }
        return false;
    }
}