class Solution {
    public boolean hasAlternatingBits(int n) {
        char[] array = Integer.toString(n, 2).toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}