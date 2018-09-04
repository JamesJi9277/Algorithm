class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOps(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(temp2 + temp1);
                } else if (token.equals("-")) {
                    stack.push(temp2 - temp1);
                } else if (token.equals("*")) {
                    stack.push(temp2 * temp1);
                } else if (token.equals("/")) {
                    stack.push(temp2 / temp1);
                }
            }
        }
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
    private boolean isOps(String s) {
        return ((s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/")));
    }
}