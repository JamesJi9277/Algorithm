class Solution {
    public String addBoldTag(String s, String[] dict) {
        // using a boolean array to indicate bold part
        boolean[] bold = new boolean[s.length()];
        for (String word : dict) {
            int start = 0;
            while (start >= 0) {
                start = s.indexOf(word, start);
                if (start < 0) {
                    break;
                }
                int end = start + word.length();
                for (int i = start; i < end; i++) {
                    bold[i] = true;
                }
                start++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bold.length; i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i] && (i == bold.length - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}