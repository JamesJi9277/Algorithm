class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        StringBuffer sb = new StringBuffer();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (stack.isEmpty() && s.equals("..")) {
                continue;
            } else if (s.equals("") || s.equals(".")) {
                continue;
            } else if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}