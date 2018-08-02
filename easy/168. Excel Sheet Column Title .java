class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        if (n < 1) {
            return sb.toString();
        }
        while (n != 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}