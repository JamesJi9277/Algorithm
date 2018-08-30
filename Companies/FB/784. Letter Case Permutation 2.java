class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        //helper(res, s, "", 0);
        helper1(res, s, new StringBuffer(), 0);
        return res;
    }
    private void helper(List<String> res, String s, String prefix, int index) {
        if (index == s.length()) {
            res.add(new String(prefix));
            return;
        }
        char c = s.charAt(index);
        if (Character.isDigit(c)) {
            helper(res, s, prefix + c, index + 1);
        } else {
            helper(res, s, prefix + Character.toUpperCase(c), index + 1);
            helper(res, s, prefix + Character.toLowerCase(c), index + 1);
        }
    }
    private void helper1(List<String> res, String s, StringBuffer sb, int index) {
        if (index == s.length()) {
            res.add(new String(sb));
            return;
        }
        char c = s.charAt(index);
        if (Character.isDigit(c)) {
            sb.append(c);
            helper1(res, s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toUpperCase(c));
            helper1(res, s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toLowerCase(c));
            helper1(res, s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}