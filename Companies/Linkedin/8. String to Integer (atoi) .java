class Solution {
    public int myAtoi(String str) {
        // must be all numerical
        // trim()
        // overflow
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean isNeg = false;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            isNeg = (str.charAt(0) == '-') ? true : false;
            str = str.substring(1);
        }
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            res = 10 * res + (c - '0');
        }
        res = isNeg ? -res : res;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }
}