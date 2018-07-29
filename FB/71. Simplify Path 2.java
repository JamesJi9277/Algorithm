class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String s : strs) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(s)) {
                stack.push(s);
            }
        }
        String res = "";
        for (String s : stack) {
            res = res + "/" + s;
        }
        return res.isEmpty() ? "/" : res;
    }
}