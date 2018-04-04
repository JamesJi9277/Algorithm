class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        str = str.trim();
        boolean isNeg = false;
        if (str.charAt(0) == '-') {
            isNeg = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        double res = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        res = (isNeg) ? -res : res;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }
}