class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 1) {
            return res;
        }
        helper(res, n, n, "");
        return res;
    }
    private void helper(List<String> res, int left, int right, String temp) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new String(temp));
            return;
        }
        if (left > 0) {
            helper(res, left - 1, right, temp + "(");
        }
        if (right > 0) {
            helper(res, left, right - 1, temp + ")");
        }
    }
}