class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int start = index;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    index++;
                }
                count.push(Integer.parseInt(s.substring(start, index)));
            } else if (c == '[') {
                stack.push(res);
                res = "";
                index++;
            } else if (c == ']') {
                StringBuffer sb = new StringBuffer(stack.pop());
                int count1 = count.pop();
                for (int i = 0; i < count1; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else {
                res += s.charAt(index++);
            }
        }
        return res;
    }
}