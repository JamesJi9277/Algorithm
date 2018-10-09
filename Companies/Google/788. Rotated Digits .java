class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (valid(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean valid(int num) {
        String s = "" + num;
        int index = 0;
        boolean flag = false;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (index == 0 && c == '0') {
                return false;
            }
            if (c == '2' || c == '5' || c == '6' || c == '9') {
                flag = true;
                index++;
            } else if (c == '0' || c == '1' || c == '8') {
                index++;
            } else {
                return false;
            }
        }
        return flag;
    }
}