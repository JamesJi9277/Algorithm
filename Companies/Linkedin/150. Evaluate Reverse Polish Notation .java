class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        for (String s : tokens) {
            if (isOps(s)) {
                int a = stack.pop();
                int b = stack.pop();
                if (s.equals("+")) {
                    stack.push(a + b);
                } else if (s.equals("-")) {
                    stack.push(b - a);
                } else if (s.equals("*")) {
                    stack.push(a * b);
                } else if (s.equals("/")) {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
    private boolean isOps(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}