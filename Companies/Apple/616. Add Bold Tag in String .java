class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String s1 : dict) {
            int start = 0;
            while (start >= 0) {
                start = s.indexOf(s1, start);
                if (start == -1) {
                    break;
                }
                for (int i = start; i < start + s1.length(); i++) {
                    bold[i] = true;
                }
                start++;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean added = false;
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
            } else {
                if (i == 0 || !bold[i - 1]) {
                    sb.append("<b>");
                }
                sb.append(s.charAt(i));
                if (i == s.length() - 1 || !bold[i + 1]) {
                    sb.append("</b>");
                }
            }
        }
        return sb.toString();
    }
}