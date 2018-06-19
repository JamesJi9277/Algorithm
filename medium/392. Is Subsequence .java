class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
            indexT++;
        }
        return false;
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length()) {
            if (t.charAt(index2++) == s.charAt(index1)) {
                index1++;
                if (index1 == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

//third write
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2++)) {
                index1++;
                if (index1 == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}