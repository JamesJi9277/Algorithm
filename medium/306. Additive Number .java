import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; Math.max(i, j) <= num.length() - i - j; ++j) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (i > 1 && num.charAt(0) == '0') {
            return false;
        }
        if (j > 1 && num.charAt(i) == '0') {
            return false;
        }
        BigInteger b1 = new BigInteger(num.substring(0, i));
        BigInteger b2 = new BigInteger(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start < num.length(); start += sum.length()) {
            b2 = b2.add(b1);
            b1 = b2.subtract(b1);
            sum = b2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}