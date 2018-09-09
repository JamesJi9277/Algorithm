class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, sb, n, n);
        return res;
    }
    private void helper(List<String> res, StringBuffer sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(new String(sb));
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            helper(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}