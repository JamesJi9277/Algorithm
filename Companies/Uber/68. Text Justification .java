class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            if (sb.length() + word.length() > maxWidth) {
                res.add(adjust(sb, maxWidth));
                sb = new StringBuffer();
            } 
            if (sb.length() + word.length() < maxWidth) {
                sb.append(word);
                sb.append(" ");
            } else if (sb.length() + word.length() == maxWidth) {
                sb.append(word);
            }
        }
        if (sb.length() > 0) {
            int n = maxWidth - sb.length();
            for (int i = 0; i < n; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
    private String adjust(StringBuffer sb, int maxWidth) {
        String[] strs = new String(sb).split(" ");
        int len = 0;
        for (int i = 0; i < strs.length; i++) {
            len += strs[i].length();
        }
        for (int i = 0; i < maxWidth - len; i++) {
            int index = strs.length > 1 ? i % (strs.length - 1) : 0;
            strs[index] += " ";
        }
        StringBuffer sb1 = new StringBuffer();
        for (String s : strs) {
            sb1.append(s);
        }
        return sb1.toString();
    }
}