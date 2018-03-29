class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s.trim();
        String[] arrays = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String ss : arrays) {
            sb.append(reverse(ss) + " ");
        }
        s = sb.toString();
        return s.substring(0, s.length() - 1);
    }
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}