public class Solution{
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0 || s.charAt(s.length() - 1) == 'e') {
            return false;
        }
        String[] str = s.split("e");
        if (str.length > 2) {
            return false;
        }
        boolean res = isValid(str[0], false);
        if (str.length == 2) {
            res &= isValid(str[1], true);
        }
        return res;
    }
    private boolean isValid(String s, boolean hasDot) {
        if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            s = s.substring(1);
        }
        char[] array = s.toCharArray();
        if (array.length == 0 || s.equals(".")) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '.') {
                if (hasDot) {
                    return false;
                } else {
                    hasDot = true;
                }
            } else {
                if (!(array[i] >= '0' && array[i] <= '9')) {
                    return false;
                }
            }
        }
        return true;
    }
}