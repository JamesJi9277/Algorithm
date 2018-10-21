class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            if (sb.length() + word.length() > maxWidth) {
                res.add(adjust(sb, maxWidth));
                sb = new StringBuffer();
            }
            if (sb.length() + word.length() == maxWidth) {
                sb.append(word);
                res.add(new String(sb));
                sb = new StringBuffer();
            } else if (sb.length() + word.length() < maxWidth) {
                sb.append(word);
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
    private String adjust(StringBuffer sb, int max) {
        String[] str = sb.toString().split(" ");
        int count = 0;
        for (String s : str) {
            count += s.length();
        }
        for (int i = 0; i < max - count; i++) {
            int index = (str.length == 1) ? 0 : (i % (str.length - 1));
            str[index] += " ";
        }
        sb = new StringBuffer();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}