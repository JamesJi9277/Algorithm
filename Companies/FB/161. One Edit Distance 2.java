class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.equals(t)) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        boolean edited = false;
        while (index1 < s.length() && index2 < t.length()) {
            char c1 = s.charAt(index1);
            char c2 = t.charAt(index2);
            if (c1 == c2) {
                index1++;
                index2++;
            } else {
                if (edited) {
                    return false;
                }
                edited = true;
                if (s.length() > t.length()) {
                    index1++;
                } else if (s.length() < t.length()) {
                    index2++;
                } else {
                    
                    index1++;
                    index2++;
                }
            }
        }
        return true;
    }
}