class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isOps(s)) {
                int i = stack.pop();
                int j = stack.pop();
                if (s.equals("+")) {
                    stack.push(i + j);
                } else if (s.equals("-")) {
                    stack.push(j - i);
                } else if (s.equals("*")) {
                    stack.push(i * j);
                } else if (s.equals("/")) {
                    stack.push(j / i);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    private boolean isOps(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}