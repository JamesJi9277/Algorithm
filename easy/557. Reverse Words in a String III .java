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

class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s1 : str) {
            sb.append(helper(s1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    private String helper(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}