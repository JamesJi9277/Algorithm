class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int index = 0;
        while (index < Math.min(str1.length, str2.length)) {
            int i = Integer.parseInt(str1[index]);
            int j = Integer.parseInt(str2[index]);
            if (i == j) {
                index++;
            } else if (i > j) {
                return 1;
            } else {
                return -1;
            }
        }
        if (str1.length > str2.length && !allZero(str1, index)) {
            return 1;
        } else if (str1.length < str2.length && !allZero(str2, index)) {
            return -1;
        } else {
            return 0;
        }
    }
    private boolean allZero(String[] str, int index) {
        for (int i = index; i < str.length; i++) {
            if (Integer.parseInt(str[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}