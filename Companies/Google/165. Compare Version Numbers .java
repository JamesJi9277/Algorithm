// 还要考虑到1.0与1这种特殊情况，
// 所以在最后还要加上是不是all zero的判断
class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return version1 == null ? -1 : 1;
        }
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            int i = Integer.parseInt(arr1[index1]);
            int j = Integer.parseInt(arr2[index2]);
            if (i > j) {
                return 1;
            } else if (i < j) {
                return -1;
            } else {
                index1++;
                index2++;
            }
        }
        if (index1 == arr1.length && index2 == arr2.length) {
            return 0;
        } else if (index1 < arr1.length && !allZero(arr1, index1)) {
            return 1;
        } else if (index2 < arr2.length && !allZero(arr2, index2)) {
            return -1;
        } else {
            return 0;
        }
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