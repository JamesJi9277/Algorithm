class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (String s : words) {
            if (sb.length() + s.length() > maxWidth) {
                res.add(adjust(sb.toString(), maxWidth));
                sb = new StringBuffer();
            }
            if (sb.length() + s.length() == maxWidth) {
                sb.append(s);
                res.add(new String(sb));
                sb = new StringBuffer();
            } else if (sb.length() + s.length() < maxWidth) {
                sb.append(s);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            while (sb.length() != maxWidth) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
    private String adjust(String s1, int maxWidth) {
        String[] strs = s1.split(" ");
        int len = 0;
        for (String s : strs) {
            len += s.length();
        }
        for (int i = 0; i < maxWidth - len; i++) {
            int index = (strs.length > 1) ? i % (strs.length - 1) : 0;
            strs[index] += " ";
        }
        StringBuffer sb = new StringBuffer();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}