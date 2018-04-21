class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operation;
        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else if (isOperation(s)) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(caculate(i, j, s));
            }
        }
        return stack.pop();
    }
    private boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
        if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    private boolean isOperation(String s) {
        HashSet<String> set = new HashSet<String>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        return set.contains(s);
    }
    private int caculate(int i, int j, String s) {
        switch (s) {
            case "+" :
                return i + j;
            case "-" :
                return j - i;
            case "*" :
                return j * i;
            case "/":
                return j / i;
        }
        return 0;
    }
}