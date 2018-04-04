class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int size = 2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j + size - 2 * i < s.length()) {
                    sb.append(s.charAt(j + size - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}