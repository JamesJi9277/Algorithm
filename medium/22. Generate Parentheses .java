// 这个相当于是一个BFS
// 每一层分别添加() 或者 ((
// 慢慢来递推
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
            res.add(temp);
            return;
        }
        if (left > 0) {
            helper(res, left - 1, right, temp + '(');
        }
        if (right > 0) {
            helper(res, left, right - 1, temp + ')');
        }
    }
}

// second
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 0) {
            return res;
        }
        helper(n, n, res, "");
        return res;
    }
    private void helper(int left, int right, List<String> res, String s) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new String(s));
            return;
        }
        if (left > 0) {
            helper(left - 1, right, res, s + "(");
        }
        if (right > 0) {
            helper(left, right - 1, res, s + ")");
        }
    }
}