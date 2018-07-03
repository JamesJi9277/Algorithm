class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                res = 10 * res + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(res);
                } else if (sign == '-') {
                    stack.push(-res);
                } else if (sign == '*') {
                    stack.push(stack.pop() * res);
                } else if (sign == '/') {
                    stack.push(stack.pop() / res);
                }
                sign = s.charAt(i);
                res = 0;
            }
        }
        res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}