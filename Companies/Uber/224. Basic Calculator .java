class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while ((i + 1) < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res = res + sign * sum;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}