// brute force
class Solution {
    public String minWindow(String s, String t) {
        if (s.contains(t)) {
            return t;
        }
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (isValid(temp, t)) {
                    if (res.equals("")) {
                        res = temp;
                    } else if (temp.length() < res.length()) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length()) {
            if (s1.charAt(index1++) == s2.charAt(index2)) {
                index2++;
                if (index2 == s2.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int sIndex = 0;
        int tIndex = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                if (++tIndex == t.length()) {
                    // 是最后一个字母，开始向前搜索
                    int end = sIndex + 1;
                    while(--tIndex >= 0) {
                        while(s.charAt(sIndex--) != t.charAt(tIndex));
                    }
                    tIndex++;
                    sIndex++;
                    if (end - sIndex < minLen) {
                        minLen = end - sIndex;
                        start = sIndex;
                    }
                }
            }
            sIndex++;
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}