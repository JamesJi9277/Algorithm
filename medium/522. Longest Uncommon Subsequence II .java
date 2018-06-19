class Solution {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return -1;
        }
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSub(strs[j], strs[i])) {
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }
    private boolean isSub(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == s2.length();
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int count = 0;
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSub(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }
    private boolean isSub(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2++)) {
                index1++;
                if (index1 == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return -1;
        }
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                if (isSub(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }
    private boolean isSub(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2++)) {
                index1++;
                if (index1 == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}