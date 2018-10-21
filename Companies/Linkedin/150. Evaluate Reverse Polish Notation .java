class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(b - a);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}