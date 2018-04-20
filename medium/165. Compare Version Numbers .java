class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < v1.length && index2 < v2.length) {
            int i = Integer.parseInt(v1[index1]);
            int j = Integer.parseInt(v2[index2]);
            if (i > j) {
                return 1;
            } else if (i < j) {
                return -1;
            } else {
                index1++;
                index2++;
                if (index1 == v1.length && !allZero(v2, index2)) {
                    return -1;
                }
                if (index2 == v2.length && !allZero(v1, index1)) {
                    return 1;
                }
            }
        }
        return 0;
    }
    private boolean allZero(String[] array, int index) {
        for (int i = index; i < array.length; i++) {
            if (Integer.parseInt(array[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}