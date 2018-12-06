class Solution {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isValid(c)) {
                sb1.append(c);
            }
        }
        sb1.reverse();
        int index1 = 0;
        int index2 = 0;
        while (index1 < sb1.length()) {
            while (!isValid(sb2.charAt(index2))) {
                index2++;
            }
            sb2.setCharAt(index2++, sb1.charAt(index1++));
        }
        return sb2.toString();
    }
    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}