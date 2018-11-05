class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String s1 : dict) {
            int start = 0;
            while (true) {
                start = s.indexOf(s1, start);
                if (start == -1) {
                    break;
                }
                for (int i = 0; i < s1.length(); i++) {
                    bold[start + i] = true;
                }
                start++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bold.length; i++) {
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