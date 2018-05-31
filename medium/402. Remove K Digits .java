class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
        while (index < num.length()) {
            while (k > 0 && !stack.isEmpty() && num.charAt(index) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        return constructNumber(stack);
    }
    private String constructNumber(Stack<Character> stack) {
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}