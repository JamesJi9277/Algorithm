class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String s = "1";
        while (--n > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                int count = 1;
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(s.charAt(i));
            }
            s = sb.toString();
        }
        return s;
    }
}