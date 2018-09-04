class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                res = res * 10 + (c - '0');
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
                sign = c;
                res = 0;
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}