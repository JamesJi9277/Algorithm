// same as next permuattion
class Solution {
    public int nextGreaterElement(int n) {
        if (n == 0) {
            return 0;
        }
        char[] array = (n + "").toCharArray();
        int i, j;
        for (i = array.length - 2; i >= 0; i--) {
            if (array[i + 1] > array[i]) {
                break;
            }
        }
        if (i == -1) {
            return -1;
        }
        for (j = array.length - 1; j > i; j--) {
            if (array[j] > array[i]) {
                break;
            }
        }
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
        reverse(array, i + 1, array.length - 1);
        long res = Long.parseLong(new String(array));
        return res <= Integer.MAX_VALUE ? (int)res : -1;
    }
    private void reverse(char[] array, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            char c = array[start + i];
            array[start + i] = array[end - i];
            array[end - i] = c;
        }
    }
}