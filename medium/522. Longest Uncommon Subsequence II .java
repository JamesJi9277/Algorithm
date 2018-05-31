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