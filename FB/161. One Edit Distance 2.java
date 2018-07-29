class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        boolean isEdited = false;
        while (index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) != t.charAt(index2)) {
                if (isEdited) {
                    return false;
                } else {
                    isEdited = true;
                    if (s.length() < t.length()) {
                        index2++;
                    } else if (s.length() > t.length()) {
                        index1++;
                    } else {
                        index1++;
                        index2++;
                    }
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}